public class Subject {

    private String subjectName;
    private int creditHours;
    private double grade;

    public Subject(String subjectName, int creditHours, double grade) {
        this.subjectName = subjectName;
        this.creditHours = creditHours;

        if (isValidGrade(grade)) {
            this.grade = grade;
        } else {
            this.grade = 0;
            System.out.println("Invalid grade. Set to 0.");
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (isValidGrade(grade)) {
            this.grade = grade;
        } else {
            System.out.println("Grade must be between 0 and 100.");
        }
    }

    public static boolean isValidGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }

    public char getLetterGrade() {

        if (grade >= 90)
            return 'A';
        else if (grade >= 80)
            return 'B';
        else if (grade >= 70)
            return 'C';
        else if (grade >= 60)
            return 'D';
        else
            return 'F';
    }

    @Override
    public String toString() {
        return subjectName + " | Credit Hours: " + creditHours
                + " | Grade: " + grade
                + " (" + getLetterGrade() + ")";
    }
}