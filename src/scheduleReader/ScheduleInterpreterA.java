package scheduleReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

import Assets.Day;
import Assets.TimeCardRow;
import scheduleAnalyzer.WeeklyTimeCard;

public class ScheduleInterpreterA {
	private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("M/d/yyyy");
	
	public static WeeklyTimeCard convertToTimeArray(String path) {

		WeeklyTimeCard fullTimeCard = new WeeklyTimeCard();
		String[][] sheet = CSVReader.convertToArray(path);
		for(String[] row : sheet) {
			if(rowCheck(row)) {
<<<<<<< Updated upstream
				String name = row[0];
				Day[] times = getTime(row, sheet[0]);
=======
				String name = row[0].trim();
				TreeSet<Day> times = getTime(row, sheet[0]);
>>>>>>> Stashed changes
				fullTimeCard.add(new TimeCardRow(name, times));
			}
		}
		return fullTimeCard;
	}
<<<<<<< Updated upstream
	private static Day[] getTime(String[] row, String[] header) {
		Day[] shifts = new Day[7];
=======
	private static TreeSet<Day> getTime(String[] row, String[] header) {
		TreeSet<Day> shifts = new TreeSet<>();
>>>>>>> Stashed changes
		int entries = 0;
		for(int i = 1; i < row.length && entries < 7; i++) {
			if(row[i].length() > 0) {
				String shift = (row[i]);
				String dateS1;
				
				if(header[i].length() > 0) {
					dateS1 = header[i].substring(header[i].indexOf(' ') + 1) + "/2019";;
				}else {
					dateS1 = header[i-1].substring(header[i-1].indexOf(' ') + 1) + "/2019";;
				}
				LocalDate dateS2 = LocalDate.parse(dateS1, DATE_FORMAT);
				shifts[entries] = new Day(dateS2, shift);
				entries++;
			}
		}

		return shifts;
	}
	
	private static boolean rowCheck(String[] row) {
		//new line
		if(row.length == 0) {
			return false;
		}
		//first row, and dividers
		if(row[0].equals("")) {
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
