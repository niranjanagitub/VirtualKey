package com.mphasis.virtualkey;

import java.util.Scanner;

public class VirtualKey {

	public static void main(String... args) {
		System.out.println("             Welcome to Virual Key              ");
		System.out.println("");
		System.out.println("");
		System.out.println("             Developer : Niranjana               ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("           Menu:                ");
		System.out.println("--------------------------------");
		System.out.println("| 1.List All Files             |");
		System.out.println("--------------------------------");
		System.out.println("| 2.Add file to Directory      |");
		System.out.println("--------------------------------");
		System.out.println("| 3.Delete file from Directory |");
		System.out.println("--------------------------------");
		System.out.println("| 4.Search file                |");
		System.out.println("--------------------------------");
		System.out.println("| 5.Exit                       |");
		System.out.println("--------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Please Select Opetion to Process...");
		VirualKeyUtil.optionSelection(sc);
        sc.close();
	}

}
