package service;
import model.Student;
import java.util.ArrayList;

public class StudentService {
    ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student){
        studentList.add(student);
        System.out.println("Student added successfully");
        System.out.println();
    }
    public void viewStudent(){
        if(studentList.isEmpty()) {
        System.out.println("No student available");
        return;
    }
    for(Student s : studentList){
        System.out.println(s);
    }
    }
}
