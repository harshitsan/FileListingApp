// This is the explorer Class of File Listing Program Containing member function(FileListing).
import java.io.*;
import java.util.*;
public class Explorer{
	static void FileListing(File[] array,String csvpath){
	  ArrayList<String> AL=new ArrayList<String>(); //ArrayList is created To store File Names as String.
	  
	 //for-each loop to store File & Sub-Folders in ArrayList.
		for (File file : array)
        { if(file.isDirectory()) 
            {  System.out.println("Subfolder found!: "+file.getName()+"\nFetching files From Subfolder...");
               AL.add("Subfolder: "+file.getName());                  //Stores Sub-folder Names in ArrayList.
      
          //**FileListing Function is called Recursively.** 
               FileListing(file.listFiles(),csvpath);
            }
        else if(file.isFile())
            { System.out.println("File Found!: "+file.getName()); 
        	  AL.add("File: "+file.getName());}                             //Stores File Names in ArrayList.
        }
		
		for (String index : AL) {                   //Writes Data from ArrayList to csv file(Append).
		       try {
		    	FileWriter csvwriter = new FileWriter(csvpath,true);
		        csvwriter.write(index+"\n");
		        csvwriter.flush();
		        csvwriter.close();
		       }
		       catch (IOException e) {
		    	e.printStackTrace();
		    	}  
		}
		System.out.println("\n'output.csv' file is updated..");
  }
}