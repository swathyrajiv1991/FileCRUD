package file_handling;

import java.util.Arrays;
import java.util.InputMismatchException;

import java.util.Scanner;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
	import java.io.IOException;
	

	public class  FileClass {

		public static void main(String[] args)  {

			Scanner scanner = new Scanner(System.in);
		
			int  c = 0;
			System.out.println("\tWelcome to LockedMe.com FMS 1.0");
			System.out.println("developed by simplylearn.\tquality is our priority\n");
			
			do {
				System.out.println("MENU OPTIONS ");
				System.out.println("press 1 for file insertion");
				System.out.println("press 2 for file deletion ");
				System.out.println("press 3 to view the files");
				System.out.println("press 4 for file searching");
				System.out.println("press 0 to exit the application ");
				System.out.println("press 5 to view the contents of file");
				System.out.println("press 6 to continue");
				
					try {
					c =scanner.nextInt();
				
					}catch (InputMismatchException e) {
						System.out.println("please enter a valid input!");
						break;
					}
					
								
				switch (c) {
				//file creation
				case 1 : 
				
				String filename;
				int temp;
				do {
					 temp=0 ;
				System.out.println("enter the name of file to be created");	
				filename =scanner.next() ;
				filename = filename.concat(".txt");
				System.out.println(filename);
				File my_file_dir = new File("/Users/bijithmp/Desktop/phase_1/phase_1_file");//specify the path
				String pathnames[] = null;;
				try {
				pathnames = my_file_dir.list();
				}catch (NullPointerException ex) {
					System.out.println("directory is empty");
				} 
				Arrays.sort(pathnames);
				
				
				for(String var:pathnames) {
					if(var.equalsIgnoreCase(filename)){
						System.out.println("file already exist ,please enter another name");
						
					
						temp =1;
						break;
						
					}
				}
				}while(temp ==1);
					
					   try(FileWriter fw=new FileWriter(filename);
									
									BufferedWriter bw=new BufferedWriter(fw);
									){
								System.out.println("your file created successfully");
								System.out.println("enter the data to be written on file ,type EXIT to stop writing  ");
								String inputString = null;
								
								while(true) {
								inputString = scanner.next();
								if(inputString.equalsIgnoreCase("EXIT"))
									 break;
								bw.write(inputString);
								}
								
								System.out.println("Messages written to file successfully");
								
							}
							catch (IOException e) {
								System.out.println("please input data");
							}
					
					   break;
					
				
				case 2 :
					//file deletion
					System.out.println("enter the name of the file to be deleted");
				try {
				String fn = scanner.next();
				fn = fn.concat(".txt");
				
				File myObj = new File("/Users/bijithmp/Desktop/phase_1/phase_1_file");//specify the path 
				
					String path[];
				   if (myObj.exists()) {
					   path = myObj.list();
					   Arrays.sort(path);
						int cha = Arrays.binarySearch(path, fn);
						if(cha>0) {
							
							 myObj = new File(fn); 
							myObj.delete();
							System.out.println("file found in the  directory ,deleted the file"+myObj.getName());
							break;
						}
						else {
							System.out.println(" file not exist");
							break;
						}
					
				   }
				
				}catch (Exception e) {
					System.out.println(e);
				}
				break;
			
				
				case 3:System.out.println("display the files ");
						File my_file_dire = new File("/Users/bijithmp/Desktop/phase_1/phase_1_file");//specify the path
						String pathnames1 [];

							if (my_file_dire.exists()) 
								{
								
								System.out.println("files"+my_file_dire.getName());
								pathnames1 = my_file_dire.list();
								Arrays.sort(pathnames1);
				   
				   
				   for (String pathname : pathnames1) {
					    // Print the names of files and directories
					    System.out.println(pathname);
					}
				  } 
				else
				 {
				   System.out.println("The directory or file does not exist.\n");
				 }
							break;
							
							
				case 4:System.out.println("enter the name of file you want to search?");
						String search_key;
						
						
						search_key = scanner.next();
						search_key = search_key.concat(".txt");
						
						
				File my_file_direc = new File("/Users/bijithmp/Desktop/phase_1/phase_1_file");//specify the path
				String path_name [];
				
				 
				   if (my_file_direc.exists()) {
					   path_name = my_file_direc.list();
					   Arrays.sort(path_name);
						int cha = Arrays.binarySearch(path_name, search_key);
						if(cha>0) {
							System.out.println("file found in the  directory .");
							break;
						}
						else {
							System.out.println(" file not found");
							break;
						}
					
				   }
				  
				
				else {
					System.out.println("no files in the directory.");
				}

				   break;
				   
				case 5:System.out.println("enter the file name you wanted to view");
						String read_file ;
						
						read_file = scanner.next();
						read_file = read_file.concat(".txt");
								try(FileReader fr=new FileReader(read_file);
						BufferedReader br=new BufferedReader(fr);
						){
					String s=null;
					System.out.println("Message from the file is ");
					
					while((s=br.readLine())!=null) {
						
						System.out.println(s);
						
					}
					
				
					}
				catch (FileNotFoundException e) {
					System.out.println("file not found in the directory");
				} catch (IOException e) {
					System.out.println(e);
				}catch (NullPointerException e) {
					System.out.println("no more files in the direcotry..");
				}
								
				
				break;
								
				
				case 0:System.out.println("Thank you for using our app!!");
				break;
				default:System.out.println("please review your input ");
				break;
				
				}
				
			
				
				
			} while(c!=0);
				
			
			
			
		scanner.close();	
		}

	}
