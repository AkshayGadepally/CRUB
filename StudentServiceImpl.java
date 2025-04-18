package crud;

import java.util.List;

public class StudentServiceImpl implements StudentService{

	@Override
	public Boolean addStudent(Student student) {
		StudentDAO dao = new StudentDAOImpl();
		return dao.addStudent(student);
	}

	@Override
	public List<Student> getAllStudentDetails() {
		StudentDAO dao = new StudentDAOImpl();
		return dao.getAllStudentDetails();
	}

	@Override
	public Student getStudentbyRollNo(int rollNo) {
		StudentDAO dao = new StudentDAOImpl();
		return dao.getStudentbyRollNo(rollNo);
	}

	@Override
	public Boolean updateStudent(Student student) {
		StudentDAO dao = new StudentDAOImpl();
		return dao.updateStudent(student);
	}

	@Override
	public Boolean deleteUsingRollNo(int RollNo) {
		StudentDAO dao = new StudentDAOImpl();
		return dao.deleteUsingRollNo(RollNo);
	}
		
}
