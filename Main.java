public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Arun", 85);
        Student s2 = new Student("Rahul", 70);
        Student s3 = new Student("Priya", 95);

        int totalMarks = s1.getMarks() + s2.getMarks() + s3.getMarks();
        double average = totalMarks / 3.0;

        System.out.println(s1.getName() + " scored " + s1.getMarks() + " marks.");
        System.out.println("Grade: " + GradeCalculator.calculateGrade(s1.getMarks()));

        System.out.println(s2.getName() + " scored " + s2.getMarks() + " marks.");
        System.out.println("Grade: " + GradeCalculator.calculateGrade(s2.getMarks()));

        System.out.println(s3.getName() + " scored " + s3.getMarks() + " marks.");
        System.out.println("Grade: " + GradeCalculator.calculateGrade(s3.getMarks()));

        // FIXED LINE: cast average to int, and store as String (not char)
        String grade = GradeCalculator.calculateGrade((int) average);
        System.out.println("Class Average = " + average + " → Grade: " + grade);
    }
}
