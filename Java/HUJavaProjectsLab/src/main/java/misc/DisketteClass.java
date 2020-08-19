package misc;
// This is for the DecimalFormat Class

public class DisketteClass
{

    // Declare Private Variables
    private char Density;
    private int BytesFilled;
    private int NumOfFiles;

    private int Dnum = 368640;              // helper data members
    private double percent = 0.0;           // helper data members

    public DisketteClass()
    {
        //Step 1. Initialize the required data members
        Density = 'L';
        BytesFilled = 0;
        NumOfFiles = 0;
    }

   public void setDensity(char n)
   {
       // Set the density to the character input
       Density = n;
   }


   // Method that increments the number of files on the diskette and return the number of files
   // on the diskette

   public int backupFile(int  Num)
   {
    int Diff =0;

    // Switch statement that calculates the density based on either L, M or H
    switch(Density)
    {
        case 'L': Dnum = 360 * 1024;
                  break;
        case 'M': Dnum = 720 * 1024;
                  break;
        case 'H': Dnum = 1440 * 1024;
                  break;
        default:  break;
    }



    Diff = Dnum - BytesFilled;

	// Control Statement that increments the number of files
    if(Num <= Diff)
    {
        NumOfFiles++;
        BytesFilled += Num;

        return NumOfFiles;
    }

    else
    {
        return 0;
    }
   }

   // Method that returns number of files
   public int getNumOfFiles()
    {
        return NumOfFiles;
    }

   // Prints appropriate information on the status of the file backup simulation
   public void printStatus()
    {
		percent = (double)(BytesFilled)/Dnum * 100.0;
                //DecimalFormat df = new DecimalFormat("0.##");

                System.out.println("Disk Capacity: " + Density + " " + "Files on Disk: " +
                NumOfFiles + " " + "Percent Full: " + percent + "%");

    }

}



