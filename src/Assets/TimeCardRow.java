package Assets;

import java.time.LocalDate;

public class TimeCardRow implements Comparable<TimeCardRow> {
	private String name;
	private boolean isMinor;
	private Day[] week;

	public TimeCardRow(String name, Day[] week) {
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

	public String getName() {
		return name;
	}

	public boolean isMinor() {
		return isMinor;
	}

	public Day getShift(int i) {
		if (i >= 0 && i <= 7) {
			return week[i];
		} else {
			return null;
		}
	}

	public Day[] getTimeCard() {
		return week;
	}

	public LocalDate getFirstDay() {
		return week[0].getDate();
	}
	public LocalDate getLastDay() {
		return week[7].getDate();
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
		return this.name + " |\t" + this.isMinor + " " + this.week[0].getShift() + " " + this.week[1].getShift() + " " + this.week[2].getShift() + " " + this.week[3].getShift() + " " + this.week[4].getShift() + " " + this.week[5].getShift() + " " + this.week[6].getShift();
	}
}
