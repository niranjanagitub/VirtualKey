package com.mphasis.virtualkey;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ListAllFiles {
	public static void listAllFiles(Scanner sc) {
		String rootFolder = "D:\\Assignment\\Root\\";
		File rootDir = new File(rootFolder);
        Set<String> fileNames = new TreeSet<>();
		if (rootDir.exists() && rootDir.isDirectory()) {
			fileNames = listSubFiles(rootDir.listFiles(),fileNames);
		}
		System.out.println("     List Fo files      ");
		System.out.println("------------------------");
		fileNames.stream().forEach(ListAllFiles::printName);
		System.out.println("------------------------");
		VirualKeyUtil.doYouWantToContinue(sc);
	}

	public static void printName(String name) {
		System.out.println(name);
		System.out.println("------------------------");
	}
	static Set<String> listSubFiles(File[] files,Set<String> fileNames) {
       if(files.length>0) {
		for(File file : files) {
        	if(file.isFile()) {
        		fileNames.add(file.getName());
        	}else if(file.isDirectory()){
        		listSubFiles(file.listFiles(),fileNames);
        	}
        }
	 }
      return fileNames;
	}
}
