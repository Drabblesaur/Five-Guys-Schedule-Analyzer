package scheduleAnalyzer;

import java.util.ArrayList;
import java.util.TreeSet;

import scheduleReader.ScheduleInterpreterA;

public class ScheduleAnalyzer {

	public static void intelligentMerge(ArrayList<String> paths) {
		TreeSet<WeeklyTimeCard> fullList = new TreeSet<WeeklyTimeCard>();
		for(String path : paths) {
			WeeklyTimeCard timeCardSheet = ScheduleInterpreterA.convertToTimeArray(path);
			fullList.add(timeCardSheet);

			System.out.println(timeCardSheet.toString());
			System.out.println();
		}
	}
}
