package service;

import db.DbConnection;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {

    public boolean isStudentExists(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isStudentValid(Student student) {
        if (student.getAge() <= 16 || student.getAge() >= 60) {
            System.out.println("Enter a valid Age between 16-60");
            return false;
        } else if (student.getMarks() > 100 || student.getMarks() < 0) {
            System.out.println("Enter the valid Marks between 0-100");
            return false;
        } else if (student.getEmail() == null || !student.getEmail().contains("@")) {
            System.out.println("Enter a valid Email that contains @");
            return false;
        } else if (student.getId() <= 0) {
            System.out.println("Enter the valid Id - greater than 0");
            return false;
        } else if (student.getName() == null || student.getName().trim().isEmpty()) {
            System.out.println("Enter the valid Name");
            return false;
        } else
            return true;
    }

    public void addStudent(Student student) {
        if (isStudentExists(student.getId())) {
            System.out.println("Student already exists with this Id");
            System.out.println();
        } else if (isStudentValid(student)) {
            String query = "INSERT INTO students(id,name,marks,age,course,email) VALUES(?,?,?,?,?,?)";

            try(Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setDouble(3, student.getMarks());
                ps.setInt(4, student.getAge());
                ps.setString(5, student.getCourse());
                ps.setString(6, student.getEmail());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student added successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void viewStudent() {
        String query = "SELECT * FROM students";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            try(ResultSet rs = ps.executeQuery()) {
                boolean found = false;

                while (rs.next()) {
                    found = true;
                    Student student = new Student();

                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setAge(rs.getInt("age"));
                    student.setCourse(rs.getString("course"));
                    student.setEmail(rs.getString("email"));
                    student.setMarks(rs.getDouble("marks"));

                    System.out.println(student);
                }
                if (!found) {
                    System.out.println("No student available");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student searchStudent(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
           try(ResultSet rs = ps.executeQuery()) {
               if (rs.next()) {
                   Student student = new Student();
                   student.setId(rs.getInt("id"));
                   student.setName(rs.getString("name"));
                   student.setAge(rs.getInt("age"));
                   student.setEmail(rs.getString("email"));
                   student.setMarks(rs.getDouble("marks"));
                   student.setCourse(rs.getString("course"));
                   return student;
               }
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateStudentName(String name, int id) {
        if(name == null || name.trim().isEmpty()){
            System.out.println("Invalid Name entered");
            return;
        }
        String query = "UPDATE students SET name = ? WHERE id=? ";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1,name);
            ps.setInt(2,id);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStudentAge(int age, int id) {
        if(age <= 16 || age >= 60){
            System.out.println("Invalid Age entered");
            return;
        }
        String query = "UPDATE students SET age = ? WHERE id=? ";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1,age);
            ps.setInt(2,id);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStudentEmail(String email, int id) {
        if(email == null || !email.contains("@")){
            System.out.println("Invalid Email entered");
            return;
        }
        String query = "UPDATE students SET email = ? WHERE id=? ";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1,email);
            ps.setInt(2,id);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStudentMarks(double marks, int id) {
        if(marks < 0 || marks > 100){
            System.out.println("Invalid Marks entered");
            return;
        }
        String query = "UPDATE students SET marks = ? WHERE id=? ";
        try(Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1,marks);
            ps.setInt(2,id);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

