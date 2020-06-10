package Assets;

import java.time.LocalDate;
import java.util.TreeSet;

public class TimeCardRow extends TreeSet<Day> implements Comparable<TimeCardRow> {
	private String name;
	private boolean isMinor;

	public TimeCardRow(String name, TreeSet<Day> week) {
		super(week);
		this.name = name;
		if (name.contains("*")) {
			isMinor = true;
			this.name = name.substring(0, name.length() - 1);
		} else {
			isMinor = false;
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

	public Day getShift(LocalDate date) {
		for(Day r : this){
			if(date.equals(r.getDate())){
				return r;
			}
		}
		return null;
	}

	public LocalDate getFirstDay() {
		return this.first().getDate();
	}
	public LocalDate getLastDay() {
		return this.last().getDate();
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
		val += "("+this.size() + " elements)";
		return val;
	}

	public String debugToString(){
		String val =  this.name + " |\t";
		for(Day i : this){
			val += "[" + i.toString() + "]     ";
		}
		val += "("+this.size() + " elements)";
		return val;
	}
}
