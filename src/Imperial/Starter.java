package Imperial;

import java.util.ArrayList;
import java.util.TreeSet;

import Assets.TimeCardRow;
import scheduleAnalyzer.ScheduleAnalyzer;
<<<<<<< Updated upstream
=======
import scheduleAnalyzer.WeeklyShiftSheet;
import scheduleReader.ScheduleInterpreterA;
>>>>>>> Stashed changes

public class Starter {
	public static void main(String[] args) {
		ArrayList<String> paths = new ArrayList<String>();
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.4 to 3.10.csv");
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.11 to 3.17.csv");
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.18 to 3.24.csv");
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.25 to 3.31.csv");
<<<<<<< Updated upstream
		System.out.println("testingb");
		ScheduleAnalyzer.intelligentMerge(paths);
=======
		TreeSet<WeeklyShiftSheet> r = ScheduleAnalyzer.getShiftSheetsFromPaths(paths);
		System.out.println(r.size());
		ArrayList<TimeCardRow> s = ScheduleAnalyzer.shiftMerge(r);
		System.out.println(s.size());
		for(TimeCardRow p : s){
			System.out.println(p.toString());
		}
>>>>>>> Stashed changes
	}
}
