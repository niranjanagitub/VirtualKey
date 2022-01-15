package com.mphasis.virtualkey;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchFile {
	private static final String ROOT_FILE = "D:\\Assignment\\Root\\";

	public static void searchFile(Scanner sc) {
		System.out.println("Enter File Name to search ");
		String fileName = sc.nextLine();
		Path path = Paths.get(ROOT_FILE);
		List<Path> result= new ArrayList<>();
		try {
			result = findByFileName(path, fileName);
		} catch (IOException e) {
			System.out.println("Unable to search file please try again");
		}
		System.out.println("Search Completed.");
		if(result.size()>0) {
			System.out.println("Search Results:");
			result.forEach(System.out::println);
		} else {
			System.out.println("No files found with name:"+fileName);
		}
        
		VirualKeyUtil.doYouWantToContinue(sc);
	}

	public static List<Path> findByFileName(Path path, String fileName) throws IOException {

		List<Path> result;
		try (Stream<Path> pathStream = Files.find(path, Integer.MAX_VALUE,
				(p, basicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fileName))) {
			result = pathStream.collect(Collectors.toList());
		}
		return result;

	}
}
