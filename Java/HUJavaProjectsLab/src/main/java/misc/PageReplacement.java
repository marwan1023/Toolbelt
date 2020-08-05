package misc;
/* Marcus Johnson
   Operating Systems
   Extra Credit */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class PageReplacement {

    public static void main(String[] Arg) {
        // Declare Variables to read in data file
        String line;
        BufferedReader in = null;
        StringTokenizer tok;

        // Declare starting index, flag, and array variables
        char Refstring[][] = new char[50][80];
        int framesize[] = new int[50];
        int index = 0;
        int pagefault[] = new int[50];
        int Refstringsize[] = new int[50];
        int flag;

        // Attempt to read in the data file
        try {
            try {
                in = new BufferedReader(new InputStreamReader(
                        new FileInputStream("input4.dat"), "UTF8"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        // Attempt to read in each character from the file after the program
        // finds the file itself
        try {

            if (in != null) {
                while ((line = in.readLine()) != null) {
                    tok = new StringTokenizer(line);
                    framesize[index] = Integer.parseInt(tok.nextToken());
                    line = in.readLine();

                    if (line != null)
                        tok = new StringTokenizer(line);

                    int k = 0;
                    Refstringsize[index] = tok.nextToken().length();
                    if (line != null)
                        tok = new StringTokenizer(line);
                    while (tok.hasMoreElements()
                            && k < tok.nextToken().length()) {
                        tok = new StringTokenizer(line);
                        Refstring[index][k] = tok.nextToken().charAt(k);
                        tok = new StringTokenizer(line);

                        k++;
                    }

                    index++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }

        // The first part of the nested for loop are for the different indexes
        for (int j = 0; j != index; j++) {
            // This for loop handles the numbering for the different algorithms
            for (int algorithm = 1; algorithm != 5; algorithm++) {
                pagefault[j] = 0;
                char frame[] = new char[framesize[j]];
                int LRUnumber[] = new int[framesize[j]];
                int LFUnumber[] = new int[framesize[j]];
                int LFU = 1;
                int FIFO = 0;

                // This for loop makes sure that the number in the reference
                // string is in the frame
                for (int n = 0; n != Refstringsize[j]; n++) {
                    flag = 0;
                    int k;
                    // This for loop cycles through the data and determines
                    // which algorithm is simulated
                    // by making sure an arbitrary variable doesn't exceed the
                    // frame number size and
                    // using if statements to select an algorithm and increment
                    // the appropriate number
                    // of page faults
                    for (k = 0; k != framesize[j]; k++) {
                        if (algorithm == 1) {
                            if (frame[k] == Refstring[j][n]) {
                                flag = 1;
                                break;
                            }
                        }
                        if (algorithm == 2) {
                            if (k <= LFU)
                                LRUnumber[k]++;
                            if (frame[k] == Refstring[j][n]) {
                                flag = 1;
                                LRUnumber[k] = 1;
                            }
                        }

                        if (algorithm == 3 || algorithm == 4) {
                            if (frame[k] == Refstring[j][n]) {
                                LFUnumber[k]++;
                                flag = 1;
                                break;
                            }
                        }
                    }

                    // This nested if statement will be responsible for
                    // reinitializing the page table
                    // back to zero between runs
                    if (flag == 0) {
                        pagefault[j]++;
                        // This series of if statements cycle through each of
                        // the algorithms and
                        // reinitializes them at the appropriate time
                        if (algorithm == 1) {
                            frame[FIFO] = Refstring[j][n];
                            FIFO++;
                            if (FIFO == framesize[j])
                                FIFO = 0;
                        }
                        int high = 0;
                        int takeout = 0;
                        if (algorithm == 2) {
                            int i;
                            if (LFU > framesize[j]) {
                                for (i = 0; i != framesize[j]; i++) {
                                    if (high < LRUnumber[i]) {
                                        high = LRUnumber[i];
                                        takeout = i;
                                    }
                                }

                                frame[takeout] = Refstring[j][n];
                                LRUnumber[takeout] = 1;
                            } else {
                                frame[LFU - 1] = Refstring[j][n];
                            }
                        }

                        if (algorithm == 3) {
                            // Set high variable to a large number to ensure
                            // success in the following
                            // if statements
                            high = 9999999;
                            int i;
                            if (LFU > framesize[j]) {
                                for (i = 0; i != framesize[j]; i++) {
                                    if (high > LFUnumber[i]) {
                                        high = LFUnumber[i];
                                        takeout = i;
                                    }
                                }
                                frame[takeout] = Refstring[j][n];
                                LFUnumber[takeout] = 0;
                            } else {
                                frame[LFU - 1] = Refstring[j][n];
                            }
                        }
                        if (algorithm == 4) {
                            high = 0;
                            int i;
                            if (LFU > framesize[j]) {
                                for (i = 0; i != framesize[j]; i++) {
                                    if (high < LFUnumber[i]) {
                                        high = LFUnumber[i];
                                        takeout = i;
                                    }
                                }
                                frame[takeout] = Refstring[j][n];
                                LFUnumber[takeout] = 0;
                            } else {
                                frame[LFU - 1] = Refstring[j][n];
                            }
                        }

                    }

                    LFU++;

                }

                // Print out appropriate statements for each of the four
                // algorithms
                if (algorithm == 1) {
                    System.out.print("Ref string: ");
                    for (int h = 0; h != Refstringsize[j]; h++)
                        System.out.print(Refstring[j][h]);
                    System.out.println("\nFrames: " + framesize[j]);
                    System.out
                            .println("FIFO: " + pagefault[j] + " page faults");
                }
                if (algorithm == 2)
                    System.out.println("LRU: " + pagefault[j] + " page faults");
                if (algorithm == 3)
                    System.out.println("LFU: " + pagefault[j] + " page faults");
                if (algorithm == 4)
                    System.out.println("MFU: " + pagefault[j] + " page faults");

            }
        }
    }
}
