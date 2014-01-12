package org.apache.ant;

import common.io.ResourceReader;
import common.io.StringWriter;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.resources.FileResource;

/**
 * Wrapper to all usage of Interpreter from Ant
 *
 * @author balnave
 */
public class SeleniumInterpreterTask extends Task {

    protected String jUnitTplPath = "/com/selenium/resources/junit3.tpl";
    protected String outDir;
    protected Vector filesets = new Vector();

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    public void setjUnitTplPath(String jUnitTplPath) {
        this.jUnitTplPath = jUnitTplPath;
    }   
    

    /**
     * Adds a set of files to be deleted.
     *
     * @param set the set of files to be deleted
     */
    public void addFileset(FileSet set) {
        filesets.addElement(set);
    }

    @Override
    public void execute() throws BuildException {
        log(String.format("%s task run from folder %s", getTaskName(), getLocation()));
        File jUnitOutDir = new File(outDir);
        if (outDir == null || outDir.isEmpty() || !jUnitOutDir.isDirectory()) {
            throw new BuildException(String.format("Expecting a outDir attribute to be a directory"));
        } else if (filesets.isEmpty()) {
            throw new BuildException(String.format("Expecting a nested fileset"));
        } else {
            for (Object set : filesets) {
                FileSet fileset = (FileSet) set;
                Iterator iterator = fileset.iterator();
                while (iterator.hasNext()) {
                    FileResource fileResource = (FileResource) iterator.next();
                    File fileIn = fileResource.getFile();
                    boolean success = generateJunitFile(fileResource, jUnitOutDir);
                }
            }
        }
    }

    /**
     * Creates a jUnit file
     *
     * @return
     */
    private boolean generateJunitFile(FileResource fileResourceIn, File baseDirOut) {
        JUnitTplFile jUnitFile = new JUnitTplFile(fileResourceIn, baseDirOut);
        String jUnitOutContent = createJunitContent(jUnitTplPath,
                                                    jUnitFile.getPackagePath(),
                                                    jUnitFile.getMethodName(), 
                                                    jUnitFile.getClassName(),
                                                    jUnitFile.getSelenesePath());
        boolean success = new StringWriter().write(jUnitFile.getJUnitFile(), jUnitOutContent);
        if (!success) {
            log(String.format("Cannot generate junit file %s from selenese file %s", jUnitFile.getJUnitFile().getAbsolutePath(), fileResourceIn.getFile().getAbsolutePath()));
        }
        return success;
    }

    /**
     * Generates a JUnit file String
     * @param resourcePath
     * @param packagePath
     * @param className
     * @param selenesePath
     * @return 
     */
    private String createJunitContent(String resourcePath, String packagePath, String className, String methodName, String selenesePath) {
        ResourceReader reader = new ResourceReader(resourcePath);
        String jUnitTplContent = reader.load();
        return String.format(jUnitTplContent, packagePath, className, methodName, selenesePath, "%s", "%s");
    }
}

class JUnitTplFile {
    
    private final String packagePath;
    private final String className;
    private final String methodName;
    private final String selenesePath;
    private final File jUnitFile;

    public JUnitTplFile(FileResource fileResourceIn, File baseDirOut) {
        File fileIn = fileResourceIn.getFile();
        File baseDirIn = fileResourceIn.getBaseDir();
        String fileNameIn = fileIn.getName();
        String fileName = fileNameIn.split("\\.")[0];
        String fileNameOut = fileName.substring(0, 1).toUpperCase() + fileName.substring(1) + "Test.java";
        String filePathOut = fileIn.getAbsolutePath().
                replace(baseDirIn.getAbsolutePath(), "").
                replace(fileNameIn, fileNameOut);
        File fileOut = new File(baseDirOut, filePathOut);
        packagePath = fileIn.getAbsolutePath().
                replace(baseDirIn.getAbsolutePath(), "").
                replace(fileNameIn, "").
                replace("\\", ".").
                replace("/", ".").
                replaceAll("^\\.", "").
                replaceAll("\\.$", "");
        className = fileNameOut.split("\\.")[0];
        methodName = className;
        selenesePath = fileIn.getAbsolutePath().replace("\\", "\\\\");
        jUnitFile = fileOut;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getSelenesePath() {
        return selenesePath;
    }

    public File getJUnitFile() {
        return jUnitFile;
    }
   
}
