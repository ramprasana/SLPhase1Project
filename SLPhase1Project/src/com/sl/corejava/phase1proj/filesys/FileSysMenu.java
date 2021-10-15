package com.sl.corejava.phase1proj.filesys;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileSysMenu {

	private final String MAIN_MENU = "<<------ Sub Menu - File System Operation ------->>";
	private final String SUB_MENU1 = "1. Add File";
	private final String SUB_MENU2 = "2. Delete File";
	private final String SUB_MENU3 = "3. Search File";
	private final String SUB_MENU4 = "4. List File";
	private final String CLOSE_APP = "99. Exit and to enter new folder path";

	private File fs;
	private String folderPath;
	private FileSystemOperation fileOps = null;
	
	public void displayMenu() {
		System.out.println(MAIN_MENU);
		System.out.println(SUB_MENU1);
		System.out.println(SUB_MENU2);
		System.out.println(SUB_MENU3);
		System.out.println(SUB_MENU4);
		System.out.println(CLOSE_APP);
		System.out.println("Please enter 1 or 2 or 3 to perform operation");
	}
 	
 	public void mainscreen() {
 		Scanner s = new Scanner(System.in);
 		String input = null;
 		
		System.out.println("************** Main Screen **************");
		System.out.println("Please enter a valid folder path: ");
 		
 		while(true) {
 			input = s.nextLine();
 			int type = determinInput(input);
 			
 			if(type == 0) // Exit 
 			{
 				break;
 			} 
 			  else if(type == 1) // Create a new file 
 			{ 
 				addFile(s);
 				displayMenu();
 			} else if(type == 2) // Delete the file 
 			{ 
 				deleteFile(s);
 				displayMenu();
 			} 
 			else if(type == 3) // Search the file 
 			{
 				searchFile(s);
 				displayMenu();
 			} 
 			else if(type == 4) // List the file  
 			{
 				freshFileList();
 				displayFiles();
 				displayMenu();
 			} else if (type == 99) {
 				getFolderPath(input);
 				
 			}
 		}
 		s.close();
 	}

 	
 	public int determinInput(String input) {
 		switch(input) {
 			case "END":
 				System.out.println("Thanks you for using the File System Application");
 				return 0;
 			case "1":
 				return 1;
 			case "2":
 				return 2;
 			case "3":
 				return 3;
 			case "4":
 				return 4;
 			default:
 				return 99;
 		}
 	}
 	
 	
	public void getFolderPath(String input) {		
		folderPath = input;
		
		fs = new File(folderPath);

		if (fs.isDirectory()) {
			fileOps = new FileSystemOperation(folderPath);
			fileOps.getFileFromFolder(fs);
			displayMenu();
		} else {
			System.out.println("Enter a valid folder path");
			System.out.println("Enter \"END\" to exit the application");
		}
	}
	
	public void freshFileList() {
		fileOps.getFileFromFolder(fs);
	}

	public void displayFiles() {		
		fileOps.displayFiles();
	}
	
	public void addFile(Scanner sadd) {
		System.out.println("Enter a file name you want to create: ");
		String fileName = sadd.nextLine();
		fileOps.addFile(fileName);
	}
	
	public void searchFile(Scanner ssearch) {
		System.out.println("Enter a file name to search in the folder: ");
		String fileName = ssearch.nextLine();
		fileOps.searchFile(fileName);
	}

	public void deleteFile(Scanner sdelete) {
		System.out.println("Enter a file name to delete: ");
		String fileName = sdelete.nextLine();
		fileOps.deleteFile(fileName);
	
	}
	public void clearScreen() {

		System.out.println("Test to clear the screen");
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (os.contains("Mac OS X")) {
			try {
				Runtime.getRuntime().exec("Clear");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
