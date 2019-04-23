package seniorproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MobileClient {

    private File input = new File("Registry.txt"); // The file object
    private StreamTokenizer tokenizer;
    private int PageBlockLength = 100;// the Page block length in bytes
    private byte ByteArray[] = new byte[PageBlockLength];

    // ------------------------------------------
    // *****Send File
    // This method Sent the file info as a class and a
    // byteArray of the files contents through a socket to a server
    private void sendFile(List<FileInfo> fileInfoList) {

        for (FileInfo fileInfo : fileInfoList) {

            try {
                String openedFile = fileInfo.getAddress();

                ObjectOutputStream out = null;

                String SocketAddress = "localhost";// Socket Address
                int port = 9000;// Port number
                Socket MSocket = null;
                try {
                    MSocket = new Socket(SocketAddress, port);
                    out = new ObjectOutputStream(MSocket.getOutputStream());
                } catch (UnknownHostException e) {
                    System.err.println("Can't locate host: " + SocketAddress);
                    sleepUntilConnect(fileInfoList);
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for "
                            + "the connection to:" + SocketAddress);
                    sleepUntilConnect(fileInfoList);
                }
                // ---End of Create Socket

                long remainingFileBytes = fileInfo.getSize();
                long ByteStart = pageReader(fileInfo);// start page 0 at file
                                                      // beginning

                long ByteEnd;
                if (remainingFileBytes < PageBlockLength)
                    ByteEnd = remainingFileBytes;// true if last page is 1st
                                                 // page
                else
                    ByteEnd = PageBlockLength;

                fileInfo.setpIndex(0);
                FileInputStream fileStream = new FileInputStream(openedFile);

                int percent;
                try {
                    String filePName = "bytearray.txt"; // Name of output file
                    File input2 = new File(filePName); // The file object

                    Writer w = new OutputStreamWriter(
                            new FileOutputStream(input2), "UTF-8");
                    PrintWriter byteArrayText = new PrintWriter(w);

                    long progress = ByteStart;
                    if (fileStream.skip(pageReader(fileInfo)) == -1) {
                        System.out.println("Error");
                    }

                    int index = 0;
                    while ((fileStream.read(ByteArray, 0,
                            (int) ByteEnd)) != -1) {
                        if (out != null)
                            out.writeObject(fileInfo);

                        byteArrayText.println(Arrays.toString(ByteArray));

                        // This is true on last page block when bytes of
                        // last block can be less then page block size
                        if (remainingFileBytes < PageBlockLength) {
                            ByteEnd = (int) remainingFileBytes;
                            remainingFileBytes -= ByteEnd;

                            System.out.println("last page");
                        } else {
                            ByteEnd = PageBlockLength;
                            remainingFileBytes -= ByteEnd;

                        }
                        progress += ByteEnd;
                        percent = (int) ((progress * 100) / fileInfo.getSize());
                        System.out.println("page [" + fileInfo.getpIndex()
                                + "] starts at " + ByteStart + " and ends at "
                                + progress);
                        System.out.println(percent + "% of "
                                + fileInfo.getName() + " is complete");
                        System.out.println(
                                "remaningbytes " + remainingFileBytes + "\n");

                        ByteStart += PageBlockLength;

                        fileInfo.setpIndex(index++);
                        pageWriter(progress, fileInfo);
                    }
                    byteArrayText.close();
                    pageWriter(-1, fileInfo);
                    System.out.println("File " + fileInfo.getName()
                            + " was sent successfully");
                } catch (FileNotFoundException e) {
                    System.err.println("could not find file " + e);

                } catch (UnknownHostException e) {
                    System.out.println("Connection lost");
                    sleepUntilConnect(fileInfoList);

                } finally {

                    if (fileStream != null)
                        fileStream.close();

                    if (out != null)
                        out.close();

                    if (MSocket != null)
                        MSocket.close();
                }

            } catch (FileNotFoundException e) {
                System.err.println("could not find file " + e);
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host:+SocketAddress");

            } catch (IOException e) {
                System.out.println(e);

            }
        }

    }

    // ------------------------------------------
    // *****sleeps until it's connected to a host
    private void sleepUntilConnect(List<FileInfo> fileInfoList) {
        try {
            System.out.print("\nsleeping...zzz");
            Thread.sleep(2000);
            System.out.print("zzzz....zzz.brzz");
            Thread.sleep(2000);
            System.out.println(
                    "zzzzz.. hey who turned on the lights? WakingUp!!\n");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException error");
        }
        sendFile(fileInfoList);
    }

    // *****Reads the Registry.txt file and stores it into the fileInfo class
    // array
    private void fileReader() throws IOException {

        String stringValue;
        long LongValue;
        List<FileInfo> fileInfoList = new ArrayList<FileInfo>();

        String s;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(input), "UTF-8"));

        while ((s = br.readLine()) != null) {
            FileInfo fileInfo = new FileInfo();
            String[] contents = s.split(" ");

            if ((stringValue = contents[0]) != null) {
                fileInfo.setName(stringValue.replaceAll("\"", ""));
            }

            if ((stringValue = contents[1]) != null) {
                fileInfo.setAddress(stringValue.replaceAll("\"", ""));
            }

            if ((LongValue = Long.parseLong(contents[2])) != 0) {
                fileInfo.setSize(LongValue);
            }

            if ((LongValue = Long.parseLong(contents[3])) != 0) {
                fileInfo.setDate(LongValue);
            }

            fileInfoList.add(fileInfo);

        }

        sendFile(fileInfoList);
        br.close();

    }

    // -----------------------------------------
    private void pageWriter(long byteStart, FileInfo fileInfo) {
        try {

            String filePName = "PageNumb.txt"; // Name of output file
            File input2 = new File(filePName); // The file object

            Writer w = new OutputStreamWriter(new FileOutputStream(input2),
                    "UTF-8");
            PrintWriter Registry2 = new PrintWriter(w);

            if (byteStart >= 0) {
                Registry2.println(byteStart + " " + fileInfo.getpIndex());
                Registry2.close();
            } else {
                Registry2.flush();
                Registry2.close();
            }

        } catch (IOException e) {
            System.out.println("Could not find registry.txt. Exeption" + e);
        }
    }

    private long pageReader(FileInfo fileInfo) {
        try {
            long saveIt = 0;
            String filePName = "PageNumb.txt"; // Name of output file
            File pageInfo = new File(filePName); // The file object

            tokenizer = new StreamTokenizer(new InputStreamReader(
                    new FileInputStream(pageInfo), "UTF-8"));

            if (tokenizer.nextToken() == StreamTokenizer.TT_NUMBER) {// Test For
                                                                     // numbToken
                saveIt = (long) tokenizer.nval;// Return next IntToken
            } else {
                System.out.println("No recovery pages");
                return 0;
            }
            if (tokenizer.nextToken() == StreamTokenizer.TT_NUMBER) {// Test For
                                                                     // numbToken
                fileInfo.setpIndex((int) tokenizer.nval);// Return next IntToken
                System.out.println("recovery pages found");
                return saveIt;
            }

        } catch (IOException e) {
            System.out.println("Can't find file Registry.txt " + e);

        }
        return 0;
    }

    // *#*#*#*MAIN()
    public static void main(String[] args) throws Exception {

        new MobileClient().fileReader();

    }
}
