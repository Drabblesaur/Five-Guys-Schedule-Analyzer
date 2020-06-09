package scheduleReader;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CSVReader {
	private final static char DELIMIT = ',';
	
	public static String[][] convertToArray(String filePath){
		File csv = new File(filePath);
		if(fileCheck(csv)) {
			return convertToArray(csv);
		}else {
			System.out.println("The file does not exist: " + filePath);
			return null;
		}
	}
	
	/**
	 * Checks to see if the file exists
	 * @param f the file to be analyzed
	 * @return true/false if the file exists
	 */
	private static boolean fileCheck(File f) {
		return f.exists();
	}
	
	/**
	 * Constructs an ArrayList of ArrayLists containing all the cells of a spreadsheet. I am using ArrayLists because they can be any length
	 * @param csv the csv file to be analyzed
	 * @return an ArrayList of ArrayLists of Strings that contain all the cells of a csv
	 */
	public static ArrayList<ArrayList<String>> parseCSV(File csv){
		ArrayList<ArrayList<String>> sheet = new ArrayList<ArrayList<String>>();
		Scanner csvScanner;
		try {
			csvScanner = new Scanner(csv);
			
			while (csvScanner.hasNextLine()) {
				String data = csvScanner.nextLine();
				ArrayList<String> line = lineParse(data);
				sheet.add(line);
			}
			csvScanner.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return sheet;
	}
	
	/**
	 * Converts a 2D array of ArrayLists to a 2D
	 * @param csv the csv to be analyzed
	 * @return the 2D array version of the 2D ArrayList
	 */
	public static String[][] convertToArray(File csv){		
		ArrayList<ArrayList<String>> sheet = parseCSV(csv);
		String[][] sheetAsArray = new String[sheet.size()][sheet.get(0).size()];
		for(int i = 0; i < sheet.size(); i++) {
			for(int j = 0; j < sheet.get(0).size(); j++) {
				sheetAsArray[i][j] = sheet.get(i).get(j);
			}
		}
		return sheetAsArray;
	}
	
	/**
	 * (helper method for parseCSV Parses a single line of a csv
	 * @param s a String that contains a line from a csv line
	 * @return an array of strings that are parsed values of the original String
	 */
	/*
	 * search for chunks
	 * remove parenthesis if there are any
	 * add them to the array
	 */
	private static ArrayList<String> lineParse(String s) {
		// check if ﻿ is there
		if(s.substring(0, 3).equals("﻿")) {
			s = s.substring(3);
		}
		ArrayList<String> line = new ArrayList<String>();
		//get cells
		int lastIndex = 0;
		boolean ignoreCommas = false;
		for(int i = 0; i < s.length(); i++) {
			//check to see if the quotation is the one that ended the cell be seeing if it is on: ",
			if(ignoreCommas == true && s.charAt(i) == '\"' && (i == s.length()-1 || s.charAt(i+1) ==  DELIMIT)) {
				ignoreCommas = false;
			}else if(ignoreCommas == false && s.charAt(i) == '\"') {
				ignoreCommas = true;
			}
			//get first to second to last cells
			if((ignoreCommas == false && s.charAt(i) == ',')) {
				String cell = trimCell(s.substring(lastIndex, i));
				//System.out.println(cell);
				line.add(cell);
				lastIndex = i;
			}
			//get the last cell
			if(i == s.length()-1) {
				String cell = trimCell(s.substring(lastIndex, s.length()));
				//System.out.println(cell);
				line.add(cell);
			}
		}
		//System.out.println();
		return line;
	}
	
	/**
	 * Helper method for lineParse and is used to trim cells that have quotations around them
	 * @param s raw cell
	 * @return processed cell
	 */
	private static String trimCell(String s) {
		//System.out.println(s);
		if(s.length() > 0 && s.substring(0, 1).equals(",")) {
			s = s.substring(1, s.length());
		}
		if(s.length() > 2 && s.substring(0, 1).equals("\"")) {
			s = s.substring(1, s.length()-1);
		}

		return s.trim();
	}
}
