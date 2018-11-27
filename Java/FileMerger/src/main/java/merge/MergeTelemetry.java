package merge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MergeTelemetry {

    private MergeTelemetry() {
    }

    public static void main(String[] args) {
        String sourceFilePath = "/Users/johnson_marcus/Dropbox/Apps/PiExperiment/logs";

        String fileType = "csv";
        String mergedFilePath = "/Users/johnson_marcus/Dropbox/Apps/PiExperiment/logs/merged/MergedTelemetry.csv";

        File mergedFile = new File(mergedFilePath);

        mergeFiles(traverse(sourceFilePath, fileType), mergedFile);
    }

    public static void mergeFiles(List<File> files, File mergedFile) {

        FileWriter fstream = null;
        BufferedWriter out = null;
        try {
            fstream = new FileWriter(mergedFile, true);
            out = new BufferedWriter(fstream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        int i = 0;
        for (File f : files) {
            System.out.println("Merging: " + f.getName());
            FileInputStream fis;
            try {
                fis = new FileInputStream(f);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(fis));

                if (i > 0) {
                    in.readLine();
                }
                String aLine;
                while ((aLine = in.readLine()) != null) {
                    if (out != null) {
                        out.write(aLine);
                        out.newLine();
                    }

                }

                in.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

        try {
            if (out != null)
                out.close();
            if (fstream != null)
                fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<File> traverse(String directory, String fileType) {

        File dir = new File(directory);
        List<File> names = new ArrayList<File>();

        if (!dir.isDirectory()) {
            Logger.getAnonymousLogger().info("Not a directory");
        } else {

            String[] fileList = dir.list(new Filter(fileType)); // Get the list
                                                                // of
                                                                // files in that
                                                                // directory

            for (String file : fileList) {
                File f = new File(dir, file); // Change from string to
                names.add(f);

            }
        }

        return names;

    }

    /**
     * The Class Filter.
     */
    static class Filter implements FilenameFilter {

        /** The extension. */
        String extension;

        /**
         * Instantiates a new filter.
         *
         * @param ext
         *            the ext
         */
        public Filter(String ext) {
            extension = "." + ext;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
         */
        public boolean accept(File dir, String filename) {
            return filename.endsWith(extension);
        }
    }
}