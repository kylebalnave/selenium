package org.apache.ant;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.resources.FileResource;

/**
 * Wrapper to all usage of Interpreter from Ant
 * @author balnave
 */
public class SeleniumInterpreterTask extends Task {
    
    protected String outDir;
    protected Vector filesets = new Vector();

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }
    
    
    
   /**
    * Adds a set of files to be deleted.
    * @param set the set of files to be deleted
    */
    public void addFileset(FileSet set) {
        filesets.addElement(set);
    }
    
    @Override
    public void execute() throws BuildException {
        log(String.format("%s task run from folder %s", getTaskName(), getLocation()));
        File jUnitOutDir = new File(outDir);
        if(outDir == null || outDir.isEmpty() || !jUnitOutDir.isDirectory()) {
            throw new BuildException(String.format("Expecting a outDir attribute to be a directory"));
        } else if(filesets.isEmpty()) {
            throw new BuildException(String.format("Expecting a nested fileset"));
        } else {
            for(Object set : filesets) {
                FileSet fileset = (FileSet)set;
                Iterator iterator = fileset.iterator();
                while(iterator.hasNext()){
                    FileResource fileResource = (FileResource) iterator.next();
                    File file = fileResource.getFile();
                    String oldFileName = file.getName();
                    String fileName = oldFileName.split("\\.")[0];
                    //log(String.format("Found file %s in basedir %s", file.getAbsolutePath(), fileResource.getBaseDir().getAbsolutePath()));
                    //
                    // create the output file path
                    String newFileName = fileName.substring(0, 1).toUpperCase() + fileName.substring(1) + ".java";
                    String fileOutPath = file.getAbsolutePath().
                            replace(fileResource.getBaseDir().getAbsolutePath(), "").
                            replace(oldFileName, newFileName);
                    File outFile = new File(outDir, fileOutPath);
                    log(String.format("JUnit output %s", outFile.getAbsolutePath()));
                    //
                    // @TODO create junit file and save to new paATH
                }
            }
        }
    }
}
