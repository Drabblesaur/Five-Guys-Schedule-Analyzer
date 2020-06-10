package Imperial;

import java.util.ArrayList;

import scheduleAnalyzer.ScheduleAnalyzer;
import scheduleReader.ScheduleInterpreterA;

public class Starter {
	public static void main(String [] args) {
		ArrayList<String> paths = new ArrayList<String>();
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.4 to 3.10.csv");
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.11 to 3.17.csv");
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.18 to 3.24.csv");
		paths.add("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.25 to 3.31.csv");
		System.out.println(ScheduleInterpreterA.convertToTimeArray("C:/users/costi/Onedrive/Desktop/Almaden Schedule 3.4 to 3.10.csv"));
		//ScheduleAnalyzer.intelligentMerge(paths);
	}
}
