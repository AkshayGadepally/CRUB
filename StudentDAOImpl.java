package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
	@Override
	public Boolean addStudent(Student student) {
		boolean isAdded = false;
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT into students (name, rollno,grade)VALUES(?,?,?)");
			
			stmt.setString(1, student.getName());
			stmt.setInt(2, student.getRollno());
			stmt.setString(3, String.valueOf(student.getGrade()));
			
			int rows = stmt.executeUpdate();
			isAdded = rows>0;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Student getStudentbyRollNo(int rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUsingRollNo(int RollNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
