package seniorproject;

import java.io.File;

public class FileCheck {
    public FileCheck(String[] FileTypes, String Directory, int time) {

        File fobj = new File(Directory);

        if (!fobj.isDirectory()) {
            System.out.println(fobj.getName() + " is not a directory");
        }

        else {
            new Initialization(fobj, FileTypes);
            waitForFile(5000);

        }
    }
    
    public void waitForFile(int time) {
        try {
            Thread.sleep(time);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}