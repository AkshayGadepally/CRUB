package crud;

import java.util.List;

public interface StudentService {
	Boolean addStudent(Student student);
	List<Student> getAllStudentDetails();
	Student getStudentbyRollNo(int rollNo);
	Boolean updateStudent(Student student);
	Boolean deleteUsingRollNo(int RollNo);
}
