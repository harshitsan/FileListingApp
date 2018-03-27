//this is a Driver class of File listing Program Containing Void main.
import java.util.*;
import java.io.*;
public class DriverClass extends Explorer{
	public static void main(String[] args) {

		System.out.print("\t\tInstructions to use:-\n\t\t1).Create a 'ABC' file containing(Main Directory & full path of output.csv file along With file name)"
				+ "\n\t\t2).make sure that an empty output.csv is present at given output location."
				+ "\n\t\t3).Execute the program by Entering the path of 'ABC.txt' file.\n\tBy.Rashim_Malhotra"); 
		System.out.print("\nEnter the Address of File.:- ");

     //takes input from user:-
		Scanner sc = new Scanner(System.in);
		 String Pathoffile=sc.nextLine();
		 sc.close();

	 //checking Existence of input file.		 		 
	    File PathsFile = new File(Pathoffile);
        if(PathsFile.exists()==false) System.out.println("File doesn't exists at given Loction. Please Enter a valid Path!");

    //Stores the path of Main Directory in 'path' and path of csv file in 'csvpath'.
          String path="";
	      String csvpath="";	    
	       try{                                          //Handling IOException.
	    	 FileReader fr= new FileReader(PathsFile);	         
	         int ch;
	         while((ch=fr.read())!=10)                    
	             path=path+((char)ch);
	         path=path.substring(0,path.length() - 1); 
	         while((ch=fr.read())!=-1)
	             csvpath=csvpath+((char)ch);
             fr.close();
	         }
	         catch (IOException e) {
		        	e.printStackTrace();
		        	} 
	      
	 //Checking Main Directory.
        File maindir = new File(path);
        if(maindir.exists()==false) System.out.println("Main Directory doesn't Exist");
        else if(maindir.isDirectory()==false) System.out.println("invalid Main Directory");
        else
        {  //storing files & Folders of Main Directory in Array
        	File array[] = maindir.listFiles();
            System.out.println("\nFiles in given directory " +maindir+" are listed below: \n");
            FileListing(array,csvpath);   // Calling FileListing function by passing array and csv path(for output). 
        } 
        System.out.println("\nAll Operations are Finished! :-)");                   
  }
}
