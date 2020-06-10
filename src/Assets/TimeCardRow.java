package Assets;

import java.time.LocalDate;
import java.util.ArrayList;

public class TimeCardRow extends ArrayList<Day> implements Comparable<TimeCardRow> {
	private String name;
	private boolean isMinor;

	public TimeCardRow(String name, ArrayList<Day> week) {
		super(week);
		this.name = name;
		if (name.contains("*")) {
			isMinor = true;
			this.name = name.substring(0, name.length() - 1);
		} else {
			isMinor = false;
		}
	}

	public String getName() {
		return name;
	}

	public boolean isMinor() {
		return isMinor;
	}

	public Day getShift(int i) {
		if (i >= 0 && i <= this.size()) {
			return this.get(i);
		} else {
			return null;
		}
	}

	public ArrayList<Day> getTimeCard() {
		return this;
	}

	public LocalDate getFirstDay() {
		return this.get(0).getDate();
	}
	public LocalDate getLastDay() {
		return this.get(this.size()-1).getDate();
	}

	public int hashCode() {
		return name.hashCode() + this.hashCode();
	}

	public int compareTo(TimeCardRow other) {
		if (this.name.compareTo(other.name) != 0) {
			return this.getFirstDay().compareTo(other.getFirstDay());
		} else {
			return this.name.compareTo(other.name);
		}
	}
	public String toString(){
		String val =  this.name + " |\t" + this.isMinor + " ";
		for(Day i : this){
			val += i.getShift() + "   ";
		}
		return val;
	}
}
