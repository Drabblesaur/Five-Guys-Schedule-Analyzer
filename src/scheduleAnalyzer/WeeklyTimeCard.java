package scheduleAnalyzer;

import java.time.LocalDate;
import java.util.ArrayList;
import Assets.TimeCardRow;

public class WeeklyTimeCard extends ArrayList<TimeCardRow> implements Comparable<WeeklyTimeCard>{
	public LocalDate getFirstDate() {
		if(this.size() > 0) {
			return this.get(0).getFirstDay();
		}else {
			return null;
		}
		
	}
	public LocalDate getLastDate() {
		if(this.size() > 0) {
			return this.get(0).getLastDay();
		}else {
			return null;
		}
	}

	public int compareTo(WeeklyTimeCard other) {
		return this.getFirstDate().compareTo(other.getFirstDate());
	}
	
	public String toString(){
<<<<<<< Updated upstream:src/scheduleAnalyzer/WeeklyTimeCard.java
		String sum = "";
=======
		String sum = "################# Shift from " + this.getFirstDate() + " - " + this.getLastDate() + "   ################\n";
>>>>>>> Stashed changes:src/scheduleAnalyzer/WeeklyShiftSheet.java
		for(TimeCardRow r : this){
			sum += (r.toString() + "\n");
		}
		return sum;
	}
}
