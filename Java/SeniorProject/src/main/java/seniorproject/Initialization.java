package seniorproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class Initialization
{
  Initialization(File fobj, String[] extensions)
  {
	 try
	 {

		String[] AllFileNames = fobj.list();
		
		
		File file = new File("Registry.txt");
		Writer w = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		PrintWriter Registry = new PrintWriter(w);
		
		for(int f=0; f< extensions.length; f++)
		{
		    String[] fileList = fobj.list(new Filter(extensions[f]));   //Get the list of files in that directory
		    for (int i =0; i < fileList.length; i++)
		    {
			    File test = new File(fobj, fileList[i]); //Change from string to File format
			    long time = test.lastModified();  // for date format
			    String path = test.getAbsolutePath();
			    path = path.replace('\\', '/');

			    /*************Used to print to file*/
			    System.out.println((char)34 +test.getName() + (char)34+" " + (char)34 + path + (char)34 + " " + test.length() + " " + time);
			    Registry.println((char)34 +test.getName() + (char)34+" " + (char)34 + path + (char)34 + " " + test.length() + " " + time);
			   
		    }

		    for (int i =0; i < AllFileNames.length; i++)
		    {
			    File allobj = new File(AllFileNames[i]);  //Change from string to File format
			    String newpath = allobj.getAbsolutePath();

			    File newobj = new File(newpath);
			    System.out.println(" ");
			    System.out.println(newpath);
			    System.out.println(newobj.isDirectory());


	            if (newobj.isDirectory())
			    {
				    new Initialization(newobj, extensions);
			    }

		    }
        }
		Registry.close();
	}
	catch (IOException ioe){ System.out.println(ioe);}
	
  }
  
  static class Filter implements FilenameFilter {

      String extension;

      public Filter(String ext) {
          extension = "." + ext;
      }

      @Override
      public boolean accept(File dir, String filename) {
          return filename.endsWith(extension);
      }
  }
  
  

}