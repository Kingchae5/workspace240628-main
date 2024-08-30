package kc.student;

public class Student {
	private String name;
	private int firstScore;
	private int secondScore;
	private int finalScore;
	private int sumScore;
	private int average;
	
	public Student() {
		super();
	}

	public Student(String name, int firstScore, int secondScore, int finalScore, int sumScore, int average) {
		super();
		this.name = name;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.finalScore = finalScore;
		this.sumScore = sumScore;
		this.average = average;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public int getSumScore() {
		return sumScore;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

}
