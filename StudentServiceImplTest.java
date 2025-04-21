package crud;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StudentServiceImplTest {
	
	private StudentService service ;
	@BeforeEach
	public void setup() {
		service = new StudentServiceImpl();
	}

    @Test
    public void testAddStudent() {
        // Arrange
       Student student = new Student();
       
       student.setName("Chan");
       student.setRollno(7);
       student.setGrade('D');
       
       //Act
       service.addStudent(student);
       
       //Assert
       List<Student> students = service.getAllStudentDetails();
       Boolean found = students.stream().anyMatch(s->"Arjun".equals(s.getName())&&
    		   										  s.getRollno()==4			&&
    		   										  "A".equals(String.valueOf(s.getGrade()))		);
       																
       assertTrue(found);    
    }
    
    @Test
    public void testDeleteStudent() {
        // Arrange
        Student student = new Student();
        student.setName("Ravi");
        student.setRollno(5);
        student.setGrade('B');

        service.addStudent(student);

        // Act
        service.deleteUsingRollNo(student.getRollno());  

        // Assert
        List<Student> students = service.getAllStudentDetails();
        boolean found = students.stream()
            .anyMatch(s -> s.getRollno() == 5);

        assertFalse(found);
    }
    
    @Test
    public void testUpdateStudent() {
        // Arrange
        Student student = new Student();
        student.setName("Kiran");
        student.setRollno(6);
        student.setGrade('C');
        service.addStudent(student);

        // Act: Update grade to 'A'
        student.setGrade('A');
        student.setName("Kiran Kumar");
        service.updateStudent(student);  // assumes update uses roll number internally

        // Assert
        List<Student> students = service.getAllStudentDetails();
        Boolean updated = students.stream().anyMatch(s->"Kiran Kumar".equals(s.getName()) && "A".equals(String.valueOf(s.getGrade())));

        assertTrue(updated);
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        Student student1 = new Student("Raj",11 , 'B');
        Student student2 = new Student("Simran",12, 'A');
        service.addStudent(student1);
        service.addStudent(student2);

        // Act
        List<Student> students = service.getAllStudentDetails();

        // Assert
        boolean foundStudent1 = students.stream()
            .anyMatch(s -> s.getRollno() == 11 && s.getName().equals("Raj"));
        boolean foundStudent2 = students.stream()
            .anyMatch(s -> s.getRollno() == 12 && s.getName().equals("Simran"));

        assertTrue(foundStudent1);
        assertTrue(foundStudent2);
    }


}

