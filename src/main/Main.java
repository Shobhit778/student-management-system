package main;
import model.Student;
import service.StudentService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        while(true) {
            System.out.println("=====STUDENT MANAGEMENT SYSTEM=====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");

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
                    System.out.println("Exiting Program");
                    System.exit(0);

                default:
                    System.out.println("Incorrect Choice");

            }
    }

    }

}
