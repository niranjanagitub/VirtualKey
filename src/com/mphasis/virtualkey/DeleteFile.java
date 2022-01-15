package com.mphasis.virtualkey;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
	private static final String ROOT_FILE = "D:\\Assignment\\Root\\";
	public static void deleteFile(Scanner sc) {
		boolean res =false;
		System.out.println("Enter File Location to Delete file under " + ROOT_FILE);
		String dir = sc.nextLine();
		System.out.println("Enter file name to be Deteted ");
		String fileNamewithoutPath = sc.nextLine();
		File fileName = new File(ROOT_FILE + dir + "\\" + fileNamewithoutPath);
		if (fileName.exists()) {
			res = fileName.delete();
			if(res) {
				System.out.println("File Success fully Deteted ");
			} else {
				System.out.println("Failed to Detete file ");
			}
		} else {
			System.out.println("File didn't exist , Please Verify file path and File Name ");
		}
	    VirualKeyUtil.doYouWantToContinue(sc);
	}
}
