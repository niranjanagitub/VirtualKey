package com.mphasis.virtualkey;

import java.util.Scanner;

public class VirualKeyUtil {
	
	public static void optionSelection(Scanner sc) {
		String option =null;
		do {
		    option = sc.nextLine();
		}while(option.trim().equals(""));

		if(!option.trim().equals("")) {
			switch (option) {
						case "1": ListAllFiles.listAllFiles(sc);
							break;
						case "2": AddFile.addFile(sc);
							break;
						case "3":DeleteFile.deleteFile(sc);
							break;
						case "4":SearchFile.searchFile(sc);
							break;
						default:
							System.out.println("Invalid Option ");
							System.out.println("");
							System.out.println("Please Select Opetion to Process...");
							optionSelection(sc);
	
			}
	   }
	}

	public static void doYouWantToContinue(Scanner sc) {
		System.out.println("do you want to continue.... y/n");
		String option = sc.nextLine();
		if(option.equals("") || (option.equalsIgnoreCase("Y"))) {
			System.out.println("Please Select Opetion to Process...");
			optionSelection(sc);
		}
	}
}
