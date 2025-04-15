package crud;

import java.util.List;

public interface StudentDAO {
		// add student info
		Boolean addStudent(Student student);
		
		//get all the students
		List<Student> getAllStudentDetails();
				
		// get the roll no
		Student getStudentbyRollNo(int rollNo);
		
		//update the student details
		Boolean updateStudent(Student student);
		
		//delete using roll no
		Boolean deleteUsingRollNo(int RollNo);

		

		
		
}
