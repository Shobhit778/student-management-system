package main;
import model.Student;
import service.StudentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        while(true) {
            System.out.println("=====STUDENT MANAGEMENT SYSTEM=====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter the choice :");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter ID :");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter NAME :");
                    String name = sc.nextLine();

                    System.out.print("Enter Age :");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter COURSE :");
                    String course = sc.nextLine();

                    System.out.print("Enter Email :");
                    String email = sc.nextLine();

                    System.out.print("Enter MARKS :");
                    double marks = sc.nextDouble();

                    Student student = new Student(id, name, course, marks, email, age);
                    studentService.addStudent(student);
                    break;

                case 2:
                    studentService.viewStudent();
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter the Id of the student to search: ");
                    int sid = sc.nextInt();
                    Student searchStudent = studentService.searchStudent(sid);
                    if(searchStudent != null){
                        System.out.println(searchStudent);
                    }
                    else{
                        System.out.println("Student not found");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = studentService.deleteStudent(deleteId);
                    if(deleted){
                        System.out.println("Student deleted successfully");
                    }
                    else{
                        System.out.println("Student not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter the ID of student to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    Student updateStudent = studentService.searchStudent(updateId);
                    if(updateStudent == null){
                        System.out.println("Student not found");
                    }
                    else{
                        System.out.println("----UPDATE TASK----");
                        System.out.println("1. Name");
                        System.out.println("2. Age");
                        System.out.println("3. Email");
                        System.out.println("4. Marks");
                        System.out.println("5. Exit");
                        System.out.print("What do you want to Update:");
                        int updateChoice = sc.nextInt();
                        sc.nextLine();

                        switch(updateChoice){
                            case 1:
                                System.out.print("Enter the updated Name: ");
                                String updateName = sc.nextLine();
                                updateStudent.setName(updateName);
                                System.out.println("Name updated Successfully");
                                break;

                            case 2:
                                System.out.print("Enter the updated Age: ");
                                int updateAge = sc.nextInt();
                                sc.nextLine();
                                updateStudent.setAge(updateAge);
                                System.out.println("Age updated Successfully");
                                break;

                            case 3:
                                System.out.print("Enter the updated Email: ");
                                String updateEmail = sc.nextLine();
                                updateStudent.setEmail(updateEmail);
                                System.out.println("Email updated Successfully");
                                break;

                            case 4:
                                System.out.print("Enter the updated Marks: ");
                                double updateMarks = sc.nextDouble();
                                updateStudent.setMarks(updateMarks);
                                System.out.println("Marks updated Successfully");
                                break;

                            case 5:
                                break;

                            default:
                                System.out.println("Incorrect Choice");
                        }

                    }
                    break;

                case 6:
                    System.out.println("Exiting Program");
                    System.exit(0);

                default:
                    System.out.println("Incorrect Choice");

            }
    }
    }

}
