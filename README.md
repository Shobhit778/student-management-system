# Student Management System

A console-based Student Management System developed using Java, JDBC, and MySQL.

## Features

- Add Student
- View All Students
- Search Student by ID
- Update Student Details
- Delete Student
- Input Validation
- Database Integration using JDBC

## Technologies Used

- Java
- JDBC
- MySQL
- IntelliJ IDEA
- Git & GitHub

## Project Structure

```text
src
├── main
├── model
├── service
└── db
```

## Database Schema

Table Name: students

| Column | Type |
|----------|----------|
| id | INT |
| name | VARCHAR |
| age | INT |
| course | VARCHAR |
| email | VARCHAR |
| marks | DOUBLE |

## How to Run

1. Clone the repository.

2. Create a MySQL database:

```sql
CREATE DATABASE student_db;
```

3. Create the students table.

4. Create a db.properties file in the project root:

```properties
db.url=jdbc:mysql://localhost:3306/student_db
db.username=your_username
db.password=your_password
```

5. Run Main.java

## Learning Outcomes

This project helped me learn:

- Core Java
- Object-Oriented Programming
- JDBC
- MySQL Integration
- Exception Handling
- Input Validation
- Git and GitHub
- Configuration Management using Properties File

## Author

Shobhit Gupta