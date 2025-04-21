package crud;

import java.util.List;

public class StudentServiceImpl implements StudentService{

	@Override
	public Boolean addStudent(Student student) {
		StudentDAO dao = new StudentDAOImpl();
		if(student == null) {
			throw new IllegalArgumentException("Student object cannot be null.");
		}
		if(student.getName() == null || student.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("Student name cannot be null.");
		}
		if(student.getRollno() <=0 ) {
			throw new IllegalArgumentException("Student Roll Number cannot be be less than or equal to 0.");
		}
		Character grade = student.getGrade();

		if (grade == null) {
		    throw new IllegalArgumentException("Grade cannot be null.");
		}

		grade = Character.toUpperCase(grade);

		if (grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D') {
		    throw new IllegalArgumentException("Grade must be A, B, C, or D.");
		}
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
		if(student == null) {
			throw new IllegalArgumentException("Student object cannot be null.");
		}
		if(student.getName() == null || student.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("Student name cannot be null.");
		}
		if(student.getRollno() <=0 ) {
			throw new IllegalArgumentException("Student Roll Number cannot be be less than or equal to 0.");
		}
		char grade = Character.toUpperCase(student.getGrade());
		if(grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D') {
			throw new IllegalArgumentException("Grade must be A, B, C, or D.");
		}
		return dao.updateStudent(student);
	}

	@Override
	public Boolean deleteUsingRollNo(int RollNo) {
		StudentDAO dao = new StudentDAOImpl();
		return dao.deleteUsingRollNo(RollNo);
	}
		
}
