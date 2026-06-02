package service;
import model.Student;
import java.util.ArrayList;

public class StudentService {
    ArrayList<Student> studentList = new ArrayList<>();

    public boolean isStudentExists(int id){
        for(Student student : studentList){
            if(student.getId() == id){
                return true;
            }
        }
        return false;
    }
    public boolean isStudentValid(Student student){
        if(student.getAge()<=16 || student.getAge()>=60){
            System.out.println("Enter a valid Age between 16-60");
            return false;
        }
        else if(student.getMarks()>100 || student.getMarks()<0){
            System.out.println("Enter the valid Marks between 0-100");
            return false;
        }
        else if(student.getEmail() == null || !student.getEmail().contains("@")){
            System.out.println("Enter a valid Email that contains @");
            return false;
        }
        else if(student.getId()<=0){
            System.out.println("Enter the valid Id - greater than 0");
            return false;
        }
        else if(student.getName() == null || student.getName().trim().isEmpty()){
            System.out.println("Enter the valid Name");
            return false;
        }
        else
            return true;
    }
    public void addStudent(Student student){
        if(isStudentExists(student.getId())){
            System.out.println("Student already exists with this Id");
            System.out.println();
        }
        else if(isStudentValid(student)) {
            studentList.add(student);
            System.out.println("Student added successfully");
            System.out.println();
        }
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
    public Student searchStudent(int Id){
        for(Student student : studentList){
            if(student.getId() == Id){
                return student;
            }
        }
        return null;
    }
    public boolean deleteStudent(int id){
        Student student = searchStudent(id);
        if(student != null){
            studentList.remove(student);
            return true;
        }
            return false;
    }

}
