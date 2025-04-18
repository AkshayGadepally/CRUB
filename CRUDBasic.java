package crud;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDBasic {
	static Scanner scan = new Scanner(System.in);
	static List<Student> list = new ArrayList<>();
	public static void main (String[] args) {
	while(true) {
			System.out.println("\nPlease select from the below options");
			System.out.println("\n1.Enter Student details \n2.show all names \n3.exit \n4.search  \n5.remove  \n6.update");
			System.out.println("\nPlease enter your choice");
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
		
		if(name.isEmpty() || rollno<=0) {
			System.out.println("Invalid input. Valid inputs for Name/Rollno");
			return;
		}
		
		Student stud = new Student(name,rollno,grade);	
		StudentDAO dao = new StudentDAOImpl();
		Boolean isAdded = dao.addStudent(stud);
		
		if(isAdded) {
			System.out.println("✅ Student added successfully");
		}
		else {
			System.out.println("❌ Failed to add student.");
		}
	}

	private static void showStudents() {
		StudentDAO dao = new StudentDAOImpl();
		List<Student> stud = dao.getAllStudentDetails();
		if(stud.isEmpty()) {
			System.out.println("There is nothing in the list");
		}else {
			for(Student stu : stud) {
				System.out.println("Name: "+stu.getName()+", Roll No: "+stu.getRollno()+", Grade:"+stu.getGrade());
			}
		}
	}
	private static void search() {
		System.out.println("Enter the rollno");
		StudentDAO dao = new StudentDAOImpl();
		List<Student> stude = dao.getAllStudentDetails();
		int Rollno = scan.nextInt();
		for(Student stud : stude) {
			if(Rollno == stud.getRollno()) {
				System.out.println("Name: "+stud.getName()+", Roll No: "+stud.getRollno()+", Grade:"+stud.getGrade());
			}
			else {
				System.out.println("The given rollno is not valid");
				break;
			}
		}
	}
	private static void remove() {
		System.out.println("Enter the rollno you want to remove");
		int Rollno = scan.nextInt();
		scan.nextLine();
		if(Rollno == 0) {
			System.out.println("not a valid roll number");
		}
		StudentDAO dao = new StudentDAOImpl();
		List<Student> studer = dao.getAllStudentDetails();
		Boolean found = false;
		for(Student stud : studer) {
			if(Rollno == stud.getRollno()){
				Boolean deleted = dao.deleteUsingRollNo(Rollno);
				if(deleted) {
					System.out.println("The Student with the Rollno "+Rollno+" is now deleted");   
					found = true;
					break;
				}				
			}	
			
		}	
		if(!found) {
			System.out.println("There is no student with the Rollno "+Rollno);
		}
	}
	private static void update() {
		
		System.out.println("Please share the rollno you want to update");
		int RollnoToUpdate = scan.nextInt();
		scan.nextLine();
		StudentDAO DAO = new StudentDAOImpl();
		Student student = DAO.getStudentbyRollNo(RollnoToUpdate);
		if(student.getRollno() <= 0) {
			System.out.println("Invalid Roll number");
		}
		System.out.println("enter what you would like to update: 1-Name, 2-Rollno, 3-Grade, 4-all fields");
		int num = scan.nextInt();
		scan.nextLine();
		switch(num) {		
			case 1:
				System.out.println("Enter the updated name:");
				String name = scan.nextLine();
				student.setName(name);
				break;
			case 2:
				System.out.println("Enter the updated rollno:");
				int rollno = scan.nextInt();
				student.setRollno(rollno);
				break;
			case 3:
				System.out.println("Enter the updated grade:");
				char grade = scan.next().charAt(0);
				student.setGrade(grade);
				break;
			case 4:
				System.out.println("Enter the updated name:");
				String nam = scan.nextLine();
				student.setName(nam);
				
				System.out.println("Enter the updated rollno:");
				int rolno = scan.nextInt();
				student.setRollno(rolno);
			
				System.out.println("Enter the updated grade:");
				char grad = scan.next().charAt(0);
				student.setGrade(grad);
				break;
			default:
				System.out.println("Please select from the given numbers");
				return;
		  }
		Boolean isUpdated = DAO.updateStudent(student);
		if(isUpdated) {
			System.out.println("✅ Student details updated successfully.");
		}else {
			System.out.println("❌ Failed to update student details.");
		}
	}
}
