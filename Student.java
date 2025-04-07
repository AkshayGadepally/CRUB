package crud;

public class Student {
	private String name;
	private int    rollno;
	private char   grade;
	
	public Student(String name,int rollno,char grade) {
		this.name = name;
		this.rollno = rollno;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno(){
		return rollno;
	}
	public void setRollno(int rollno){
		this.rollno=rollno;
	}
	public int getGrade(){
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
}
