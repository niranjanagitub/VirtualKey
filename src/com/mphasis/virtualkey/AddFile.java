package com.mphasis.virtualkey;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddFile {
	private static final String ROOT_FILE = "D:\\Assignment\\Root";

	public static void addFile(Scanner sc) {
		boolean success = false;
		System.out.println("Enter File Location to create file under " + ROOT_FILE);
		String dir = sc.nextLine();
		String path = "";
		String[] dirNames = dir.split("\\\\");
		for (String dirName : dirNames) {
			path += "\\" + dirName;
			File directory = new File(ROOT_FILE + path);
			if (!directory.exists()) {
				success = directory.mkdir();
				if (!success) {
					System.out.printf("Failed to create new directory: %s%n", directory);
					System.out.println("Please Retry again");
					VirualKeyUtil.doYouWantToContinue(sc);
				}
			}
		}
		System.out.println("Enter file name to be created ");
		String filename = sc.nextLine();
		File fileName = new File(ROOT_FILE + path + "\\" + filename);
		if (fileName.exists()) {
			System.out.println("File already exists");
		} else {
			try {
				success = fileName.createNewFile();
				if (success) {
					System.out.println("Successfully created new file:" + fileName);
					System.out.println("Do you want to write data inside file Y/N");
					String res = sc.nextLine();
					if (res.equalsIgnoreCase("Y")) {
						writeFile(sc, fileName);
						System.out.println("Successfully updated data in:" + fileName);
					}
				} else {
					System.out.println("Failed to create new file:" + fileName);
				}
			} catch (IOException e) {
				System.out.println("Failed to create new file:" + e.getLocalizedMessage());
			}
		}

		VirualKeyUtil.doYouWantToContinue(sc);
	}

	public static void writeFile(Scanner sc, File fileName) {
		try (BufferedWriter f_writer = new BufferedWriter(new FileWriter(fileName))) {
          while(sc.hasNext()) {
        	  String data = sc.nextLine();
        	  if(data.equals("--EOF--")) {
        		  break;
        	  }
        	  f_writer.write(data+"\n");
          }
          f_writer.flush();
		} catch (IOException e) {
			System.out.println("Failed to write data inside file:" + e.getLocalizedMessage());
		}
	}
}
