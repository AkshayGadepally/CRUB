package crud;

import java.util.List;

public interface StudentDAO {
		// add student info
		Boolean addStudent(Student student);
		
		// get the roll no
		Student getStudentbyRollNo(int rollNo);
		
		//get all the students
		List<Student> getStudentDetails();
		
		//update the student details
		Boolean updateStudent(Student student);
		
		//delete using roll no
		Boolean deleteUsingRollNo(int RollNo);

		

		
		
}
