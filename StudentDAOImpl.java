package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	public List<Student> getAllStudentDetails() {
		List<Student> students = new ArrayList<>();
		try {
			Connection conn = DBUtil.getConnection();
			String query = "SELECT * from students";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setName(rs.getString("name"));
				s.setRollno(rs.getInt("rollno"));
				s.setGrade(rs.getString("grade").charAt(0));
				students.add(s);
			}
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return students;
	}
	
	@Override
	public Student getStudentbyRollNo(int rollNo) {
		Student student = new Student();
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * from students where rollno = ?");
			stmt.setInt(1,rollNo);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				
				student.setName(rs.getString("name"));
				student.setRollno(rs.getInt("rollno"));
				student.setGrade(rs.getString("grade").charAt(0));
				student.getName();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return student;
	}
	
	@Override
	public Boolean updateStudent(Student student) {
		Boolean isUpdated = false;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE students SET name = ? , rollno = ? , grade =? WHERE rollno = ?");
			
			stmt.setString(1,student.getName());
			stmt.setInt(2,student.getRollno());
			stmt.setString(3, String.valueOf(student.getGrade()));
			stmt.setInt(4, student.getRollno());
			
			int rows = stmt.executeUpdate();
			isUpdated = rows>0;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	

	@Override
	public Boolean deleteUsingRollNo(int RollNo) {
		// TODO Auto-generated method stub
		Boolean isUpdated = false;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM students where rollno = ?");
			stmt.setInt(1, RollNo);
			int RowsEffected = stmt.executeUpdate();
			isUpdated = RowsEffected > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isUpdated;
	}
	
}
