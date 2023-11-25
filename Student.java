import java.util.Scanner;
import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private int age;
      public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
    public int getid() {
        return 0;
    }
}
class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<Student>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void viewAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getid() == id) {
                return student;
            }
        }
        return null;
    }
    public void deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student with ID " + id + " has been deleted.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
              System.out.println("\nStudent Management System");
              System.out.println("1.  Student ");
             System.out.println("2. View All Students");
               System.out.println("3. Find Student by ID");
              System.out.println("4. Delete Student");
             System.out.println("5. Exit");
             System.out.print("Enter your choice: ");
                   int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();
                    Student student = new Student(id, name, age);
                    sms.addStudent(student);
                    break;
                    case 2:
                    sms.viewAllStudents();
                    break;
                    case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = sms.findStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    sms.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
