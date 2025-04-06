package practice;
import java.util.ArrayList;
import java.util.Scanner;

public class CrubBasic {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Student> list = new ArrayList<>();
	public static void main (String[] args) {
	while(true) {
			System.out.println("\n 1.Student details \n 2.show all names \n 3.exit \n 4.search \n 5.remove \n 6. update");
			System.out.println("Please enter your choice");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				addStudent();
				break;
			case 2:
				showStudents();
				break;
			case 3:
				System.out.println("exiting");
				return;
			case 4:
				search();
				break;
			case 5:
				remove();
				break;
			case 6:
				update();
				break;
			default:
				System.out.println("not a valid command");
			}
			
		}
	
	}
	
	static void addStudent() {
		scan.nextLine();
		System.out.println("Enter Name");
		String name = scan.nextLine();
		System.out.println("Enter Roll no");
		int rollno = scan.nextInt();
		System.out.println("Enter Grade");
		char grade = scan.next().charAt(0);
		Student stud = new Student(name,rollno,grade);
		list.add(stud);
	}

	private static void showStudents() {
		// TODO Auto-generated method stub
		if(list.isEmpty()) {
			System.out.println("There is nothing in the list");
		}else {
			for(Student stud : list) {
				System.out.println("Name: "+stud.getName()+", Roll No: "+stud.getRollno()+", Grade:"+stud.getGrade());
			}
		}
	}
	private static void search() {
		System.out.println("Enter the rollno");
		int Rollno = scan.nextInt();
		for(Student stud : list) {
			if(Rollno == stud.getRollno()) {
				System.out.println("Name: "+stud.getName()+", Roll No: "+stud.getRollno()+", Grade:"+stud.getGrade());
			}
		}
	}
	private static void remove() {
		System.out.println("Enter the rollno you want to remove");
		int Rollno = scan.nextInt();
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getRollno() == Rollno) {
				list.remove(i);
			}
		}
	}
	private static void update() {
		System.out.println("Please share the rollno you want to update");
		int Rollno = scan.nextInt();
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getRollno() == Rollno) {
			System.out.println("enter what you would like to update: 1-Name, 2-Rollno, 3-Grade, 4-all fields");
			int num = scan.nextInt();
			scan.nextLine();
			switch(num) {
			case 1:
				System.out.println("Enter the updated name:");
				String name = scan.nextLine();
				list.get(i).setName(name);
				break;
			case 2:
				System.out.println("Enter the updated rollno:");
				int rollno = scan.nextInt();
				list.get(i).setRollno(rollno);
				break;
			case 3:
				System.out.println("Enter the updated grade:");
				char grade = scan.next().charAt(0);
				list.get(i).setGrade(grade);
				break;
			case 4:
				addStudent();
				break;
			}
		}
	  }
	}
}
