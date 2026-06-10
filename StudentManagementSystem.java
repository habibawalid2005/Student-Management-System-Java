import java.util.ArrayList;

public class StudentManagementSystem {

    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public void addSubjectToStudent(int id, Subject subject) {

        Student s = searchStudent(id);

        if (s != null) {
            s.addSubject(subject);
            System.out.println("Subject added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public boolean removeStudent(int id) {

        Student s = searchStudent(id);

        if (s != null) {
            students.remove(s);
            return true;
        }

        return false;
    }

    public void removeSubjectFromStudent(int id, String name) {

        Student s = searchStudent(id);

        if (s != null && s.removeSubject(name)) {
            System.out.println("Subject removed.");
        } else {
            System.out.println("Subject or student not found.");
        }
    }

    public Student findHighestGPA() {

        if (students.isEmpty()) {
            return null;
        }

        Student best = students.get(0);

        for (Student s : students) {

            if (s.calculateGPA() > best.calculateGPA()) {
                best = s;
            }
        }

        return best;
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.displayStudentInfo();
            System.out.println("----------------------");
        }
    }
}