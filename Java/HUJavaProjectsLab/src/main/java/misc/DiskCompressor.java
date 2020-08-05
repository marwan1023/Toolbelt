package misc;
/**
	* @author Marcus Johnson
	* @date September 24, 2000
	* @project File Backup Simulation
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat; // This is for SimpleDateFormat class
import java.util.Date;
import java.util.StringTokenizer;

public class DiskCompressor {
    // Define Main Funtion
    public static void main(String[] args) {

        // Declared Class Variables

        BufferedReader in = null;
        String line;
        StringTokenizer tok;
        BackupClass bk = null;
        char type;
        int Size;
        int yy, mm, dd;

        // Attempt to read the input data file
        try {
            try {
                in = new BufferedReader(new InputStreamReader(
                        new FileInputStream("input.dat"), "UTF8"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) // check if file is found
        {
            System.out.println(e.toString());
            System.exit(1);
        }

        try {
            // Reads a line from the file
            line = null;

            // Creates an instance of the backupClass with the current date and
            // the input line

            Date now = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
            String date = df.format(now);
            tok = new StringTokenizer(date);

            yy = Integer.parseInt(tok.nextToken());
            mm = Integer.parseInt(tok.nextToken());
            dd = Integer.parseInt(tok.nextToken());

            if (in != null) {
                
                String firstLine = "";
                if ((firstLine = in.readLine()) != null)
                    bk = new BackupClass(mm, dd, yy, firstLine);
                
                
                while ((line = in.readLine()) != null) // read a line until EOF
                {
                    // System.out.println(line);
                    // This gets the two tokens separated by " "(1 blank)

                    tok = new StringTokenizer(line);
                    type = tok.nextToken().charAt(0); // this puts the file type
                                                      // in
                                                      // the variable type
                    // Gets the file size
                    Size = Integer.parseInt(tok.nextToken());

                    if (bk.backupFile(Size, type) == 0) // call backupFile
                                                        // method
                    // if 0 ret then Error,
                    // otherwise everything is
                    // OK
                    {
                        System.out.println(
                                "****ERROR*****unable to back up file type "
                                        + type + " and size " + Size);
                    }

                }
            }

            if (bk != null)
               bk.printStatus();
            
            System.runFinalization(); // Run finalizer on exit
        } catch (IOException e) {
            System.out.println("Error:  " + e.toString());
        }
    }
}
