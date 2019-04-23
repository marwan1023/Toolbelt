package seniorproject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**

 * Connection.java
 *
 *
 * @author Jalatee Worjloh
 */
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection extends Thread {

    private InetAddress theHost;
    private File dirName;

    private Socket outputLine;
    private FileInfo f = new FileInfo();

    public Connection(Socket s) {
        outputLine = s;
    }

    public void run() {
        // getOutputStream returns an OutputStream object
        // allowing ordinary file IO over the socket.

        try {
            theHost = InetAddress.getLocalHost();
        }

        catch (UnknownHostException uhe) {
        }

        String hostName = theHost.getHostName();
        String hostAddress = theHost.getHostAddress();

        System.out.println("Host Name: " + hostName);
        System.out.println("Host Address: " + hostAddress);

        // Create directory and add files to the directory
        File inputFile, outputFile;

        dirName = new File(hostAddress);

        if (!dirName.exists()) {
            if (dirName.mkdir()) {
                System.out.println("A directory has been created");
                System.out.println(
                        "The name of your directory is: " + hostAddress);
            }

        }

        DataInputStream ds = null;
        DataOutputStream dos = null;

        try {

            int bytesRead;

            /*
             * ObjectInputStream in = new
             * ObjectInputStream(outputLine.getInputStream()); y =
             * in.readLine();
             */
            ObjectInputStream in = new ObjectInputStream(
                    outputLine.getInputStream());

            f = (FileInfo) in.readObject();

            inputFile = new File(f.getAddress());
            outputFile = new File(hostAddress, f.getName());

            byte[] buffer = new byte[1024];

            ds = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(inputFile)));

            dos = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(outputFile)));

            while ((bytesRead = ds.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);

            }

            System.out.println(f.getName() + " has been copied to: " + dirName);

        } catch (Exception ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (ds != null)
                    ds.close();

                if (dos != null)
                    dos.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
