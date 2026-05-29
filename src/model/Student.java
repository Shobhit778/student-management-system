package model;

public class Student {

    private static String college = "AMITY UNIVERSITY";
    private int  id;
    private String name;
    private int age;
    private String course;
    private String email;
    private double marks;

    public Student(){
    }

    public Student (int id, String name, String course, double marks, String email, int age){
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.age = age;
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{ " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                ", marks=" + marks +
                " }";
    }
}
