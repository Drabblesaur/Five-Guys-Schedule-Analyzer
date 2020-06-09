package scheduleAnalyzer;

import java.time.LocalDate;
import java.util.ArrayList;

import Assets.Day;

public class Schedule extends ArrayList<Day> implements Comparable<Schedule>{
	private String name;
	
	public Schedule(String name) {
		this.name = name;
	}
	
	public LocalDate getFirstDate() {
		if(this.size() > 0) {
			return this.get(0).getDate();
		}else {
			return null;
		}
		
	}
	public LocalDate getLastDate() {
		if(this.size() > 0) {
			return this.get(this.size()-1).getDate();
		}else {
			return null;
		}
		
	}
	public String getName() {
		return name;
	}
	public int compareTo(Schedule other) {
		return this.name.compareTo(other.name);
	}
}
