import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String major;

    private ArrayList<Subject> subjects;

    public Student(int id, String name, String major) {

        this.id = id;
        this.name = name;
        this.major = major;

        subjects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public boolean removeSubject(String subjectName) {

        for (int i = 0; i < subjects.size(); i++) {

            if (subjects.get(i).getSubjectName()
                    .equalsIgnoreCase(subjectName)) {

                subjects.remove(i);
                return true;
            }
        }

        return false;
    }

    public double calculateGPA() {

        if (subjects.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Subject s : subjects) {
            total += s.getGrade();
        }

        return total / subjects.size();
    }

    public void displayStudentInfo() {

        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Major: " + major);

        System.out.println("Subjects:");

        if (subjects.isEmpty()) {
            System.out.println("No subjects.");
        } else {

            for (Subject s : subjects) {
                System.out.println(s);
            }
        }
    }
}