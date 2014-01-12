package org.apache.ant;

import java.io.File;
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
    
    protected Vector filesets = new Vector();
    
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
        if(filesets.isEmpty()) {
            throw new BuildException(String.format("Expecting a nested fileset", getTaskName()));
        } else {
            for(Object set : filesets) {
                FileSet fileset = (FileSet)set;
                while(fileset.iterator().hasNext()){
                    FileResource fileResource = (FileResource) fileset.iterator().next();
                    File file = fileResource.getFile();
                    log(String.format("Found file %s", file.getAbsolutePath()));
                }
            }
        }
    }
}
