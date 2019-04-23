package seniorproject;

import java.io.Serializable;

//#####Contains Information about the files given by Registry.txt
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;// File Name
    private String address;// File URL
    private long size;// Size of File
    private long date;// Exact time of the files last update this must be
                      // converted into type date in order to view
    private int pIndex;// Page index of a file

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getpIndex() {
        return pIndex;
    }

    public void setpIndex(int pIndex) {
        this.pIndex = pIndex;
    }

}
