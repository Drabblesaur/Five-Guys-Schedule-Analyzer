package scheduleAnalyzer;

import java.util.ArrayList;
import java.util.TreeSet;

import scheduleReader.ScheduleInterpreterA;

public class ScheduleAnalyzer {

	public static TreeSet<WeeklyShiftSheet> getShiftSheetsFromPaths(ArrayList<String> paths) {
		TreeSet<WeeklyShiftSheet> fullList = new TreeSet<>();
		for(String path : paths) {
			WeeklyShiftSheet timeCardSheet = ScheduleInterpreterA.convertToTimeArray(path);
			fullList.add(timeCardSheet);

			System.out.println(timeCardSheet.toString());
			System.out.println();
		}
		return fullList;
	}
}
