package com.sl.corejava.phase1proj.filesys;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileSystemOperation {
	
	private String filePath;
	private List<String> fileList;
	
	public FileSystemOperation(String filePath) {
		super();
		this.filePath = filePath;
	}

	
	public String getFilePath() {
		return filePath;
	}


	public List<String> getFileList() {
		return fileList;
	}


	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public void getFileFromFolder(File fs) {
		String[] files = fs.list();
		List<String> lstFiles = Arrays.asList(files);
		setFileList(lstFiles);
		sortFiles();
	}
	
	public void sortFiles() {
		Collections.sort(fileList);
	}
	
	public void displayFiles() {
		System.out.println("***************List of Files****************");
		for(String file: fileList) {
			System.out.println(file);
		}
		System.out.println("***************End of File List****************");
	}
	
	public void addFile(String fileName) {
		
		String completePath = this.filePath + System.getProperty("file.separator") + fileName;
		try {
		
			File fs = new File(completePath);
			boolean isFileCreated = fs.createNewFile();
			if(isFileCreated) {
				System.out.println("File " + fileName + " successfully created");
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
				
	}
	
	public void searchFile(String fileName) {
		boolean isFound = fileList.contains(fileName);
		if(isFound) {
			int foundAt = fileList.indexOf(fileName);
			System.out.println("File found : " + fileList.get(foundAt));
		} else {
			System.out.println("File not found");;
		}
	}
	
	public void deleteFile(String fileName) {
		String completePath = this.filePath + System.getProperty("file.separator") + fileName;
		File fs = new File(completePath);
		if(fs.delete()) 
		{
			System.out.println("File deleted successfuly");
		} else {
			System.out.println("Failed to delete the given file");
		}
	}
	
}
