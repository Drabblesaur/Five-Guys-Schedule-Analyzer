package scheduleReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

import Assets.Day;
import Assets.TimeCardRow;
import scheduleAnalyzer.WeeklyShiftSheet;

public class ScheduleInterpreterA {
	private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("M/d/yyyy");
	
	public static WeeklyShiftSheet convertToTimeArray(String path) {

		WeeklyShiftSheet fullTimeCard = new WeeklyShiftSheet();
		String[][] sheet = CSVReader.convertToArray(path);
		for(String[] row : sheet) {
			if(rowCheck(row)) {
				String name = row[0].trim();
				TreeSet<Day> times = getTime(row, sheet[0]);
				fullTimeCard.add(new TimeCardRow(name, times));
			}
		}
		return fullTimeCard;
	}
	
	private static TreeSet<Day> getTime(String[] row, String[] header) {
		TreeSet<Day> shifts = new TreeSet<>();
		for(int i = 2; i <= 14; i += 2){
			LocalDate date = LocalDate.parse(header[i-1].substring(header[i-1].indexOf(' ') + 1) + "/2019", DATE_FORMAT);
			String shift;
			if(row[i].length() > 0 && !row[i].contains("w/")){
				shift = row[i];
			}else{
				shift = row[i-1];
			}
			shifts.add(new Day(date, shift));
		}
		return shifts;
	}
	
	private static boolean rowCheck(String[] row) {
		//new line
		if(row.length == 0) {
			return false;
		}
		//first row, and dividers
		if(row[0].length() == 0 || row[1].contains("Monday")){
			return false;
		}
		//initials (not sure what this is)
		if(row[0].equals("MIC")) {
			return false;
		}
		//positions
		if(row[0].equals("Grill") || row[0].equals("Register") || row[0].equals("Dressing") || row[0].equals("Fries")) {
			return false;
		}
		//ending
		if(row[0].equals("Bodies") || Character.isDigit(row[0].charAt(0)) || row[0].equals("Total Hours") || row[0].contains("Projected")) {
			return false;
		}
		return true;
	}
}
