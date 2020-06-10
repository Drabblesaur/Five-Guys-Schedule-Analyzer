package Assets;

import java.time.LocalDate;
<<<<<<< Updated upstream

public class TimeCardRow implements Comparable<TimeCardRow> {
=======
import java.util.TreeSet;

public class TimeCardRow extends TreeSet<Day> implements Comparable<TimeCardRow> {
>>>>>>> Stashed changes
	private String name;
	private boolean isMinor;
	private Day[] week;

<<<<<<< Updated upstream
	public TimeCardRow(String name, Day[] week) {
=======
	public TimeCardRow(String name, TreeSet<Day> week) {
		super(week);
>>>>>>> Stashed changes
		this.name = name;
		this.week = week;
		if (name.contains("*")) {
			isMinor = true;
			this.name = name.substring(0, name.length() - 1);
		} else {
			isMinor = false;
		}

		if (week.length != 7) {
			throw new IllegalArgumentException(
					"There must be 7 elements in a timecard. This argument contains: " + week.length);
		}
	}

	public void merge(TimeCardRow other){
		for(Day r : other){
			this.add(r);
		}
	}

	public String getName() {
		return name;
	}

	public boolean isMinor() {
		return isMinor;
	}

<<<<<<< Updated upstream
	public Day getShift(int i) {
		if (i >= 0 && i <= 7) {
			return week[i];
		} else {
			return null;
=======
	public Day getShift(LocalDate date) {
		for(Day r : this){
			if(date.equals(r.getDate())){
				return r;
			}
>>>>>>> Stashed changes
		}
		return null;
	}

<<<<<<< Updated upstream
	public Day[] getTimeCard() {
		return week;
	}

	public LocalDate getFirstDay() {
		return week[0].getDate();
	}
	public LocalDate getLastDay() {
		return week[7].getDate();
=======
	public TreeSet<Day> getTimeCard() {
		return this;
	}

	public LocalDate getFirstDay() {
		return this.first().getDate();
	}
	public LocalDate getLastDay() {
		return this.last().getDate();
>>>>>>> Stashed changes
	}

	public int hashCode() {
		return name.hashCode() + week.hashCode();
	}

	public int compareTo(TimeCardRow other) {
		if (this.name.compareTo(other.name) != 0) {
			return this.getFirstDay().compareTo(other.getFirstDay());
		} else {
			return this.name.compareTo(other.name);
		}
	}
	public String toString(){
<<<<<<< Updated upstream
		return this.name + " |\t" + this.isMinor + " " + this.week[0].getShift() + " " + this.week[1].getShift() + " " + this.week[2].getShift() + " " + this.week[3].getShift() + " " + this.week[4].getShift() + " " + this.week[5].getShift() + " " + this.week[6].getShift();
=======
		String val =  this.name + " |\t" + this.isMinor;
		for(Day i : this){
			val += "   " + i.getShift();
		}
		val += "(" + this.size() + ")";
		return val;
>>>>>>> Stashed changes
	}
}
