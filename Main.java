import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentManagementSystem system = new StudentManagementSystem();

        int choice;

        do {

            System.out.println("\n===== Student Management =====");

            System.out.println("1. Add Student");
            System.out.println("2. Add Subject to Student");
            System.out.println("3. Display Student Information");
            System.out.println("4. Calculate Student GPA");
            System.out.println("5. Display All Students");
            System.out.println("6. Remove Student");
            System.out.println("7. Remove Subject from Student");
            System.out.println("8. Show Highest GPA Student");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Major: ");
                    String major = input.nextLine();

                    Student st = new Student(id, name, major);

                    system.addStudent(st);

                    System.out.println("Student added successfully.");

                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    int sid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Subject Name: ");
                    String subName = input.nextLine();

                    System.out.print("Enter Credit Hours: ");
                    int ch = input.nextInt();

                    System.out.print("Enter Grade: ");
                    double grade = input.nextDouble();

                    if (Subject.isValidGrade(grade)) {

                        Subject sub = new Subject(subName, ch, grade);

                        system.addSubjectToStudent(sid, sub);

                    } else {
                        System.out.println("Invalid grade.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = input.nextInt();

                    Student found = system.searchStudent(searchId);

                    if (found != null) {
                        found.displayStudentInfo();
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int gpaId = input.nextInt();

                    Student gpaStudent = system.searchStudent(gpaId);

                    if (gpaStudent != null) {

                        System.out.println(
                                "GPA = "
                                        + gpaStudent.calculateGPA());

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 5:

                    system.displayAllStudents();

                    break;

                case 6:

                    System.out.print("Enter Student ID: ");
                    int removeId = input.nextInt();

                    if (system.removeStudent(removeId)) {
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 7:

                    System.out.print("Enter Student ID: ");
                    int rsid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Subject Name: ");
                    String rsname = input.nextLine();

                    system.removeSubjectFromStudent(
                            rsid,
                            rsname);

                    break;

                case 8:

                    Student top = system.findHighestGPA();

                    if (top != null) {

                        System.out.println(
                                "Top Student: "
                                        + top.getName());

                        System.out.println(
                                "GPA: "
                                        + top.calculateGPA());

                        top.displayStudentInfo();

                    } else {
                        System.out.println("No students.");
                    }

                    break;

                case 9:

                    System.out.println("Goodbye!");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        input.close();
    }
}