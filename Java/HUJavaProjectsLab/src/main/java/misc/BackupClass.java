package misc;
public class BackupClass
{
    private int Month, Day, Year,sum;

    //Array of 10 disketteClass reference variables
    private DisketteClass[] DisketteArray = new DisketteClass[10];

    public BackupClass(int month, int day, int year, String Density)
    {
        Month = month;

        sum = 0;

        Day = day;

        Year = year;

        char[] densityList = Density.toCharArray();
        
        int i = 0;
        for (char d : densityList)
        {
            DisketteArray[i] = new DisketteClass();
            DisketteArray[i].setDensity(d);
            i++;
        }
     
        System.out.println("Current Date: " + Month + "/" + Day + "/" + Year);
        System.out.println("READY TO BEGIN BACKUP");
    }

    public int backupFile(int Size, char Type)
    {
        int temp = 0;

        //  Case statement that determines the compressed file size.


		switch (Type)
		{
			case 'B':
			Size *= 1.0;
			break;

			case 'I':
			Size *= .8;
			break;

			case 'T':
			Size *= .6;
			break;

			default:
			break;
		}
		
        // This checks if file succefully backed up increments the total files,
        // and returns 1 if OK.
        for ( int i= 0; i < DisketteArray.length; i++)
        {
            temp = DisketteArray[i].backupFile(Size);
            
            if (temp != 0)
            {
                 sum ++;
                 return 1;
            }

        }

        return 0;

    }

    public void printStatus()
    {

        // Prints out the correct output as shown in the program spec. using
        // the PrintStatus() method in the disketteArray class.

        System.out.println("Total number of files backed up on " + Month + "/" + Day + "/" + Year
        + " is: " + sum);

        for (int i = 0;i < DisketteArray.length;i++)
        {DisketteArray[i].printStatus(); }
    }

    protected void finalize()  // destructor
    {
        printStatus();
    }
}


