import java.util.*;

class Learner {
    private String rollNo;
    private String fullName;
    private List<Integer> scores;

    public Learner(String rollNo, String fullName) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.scores = new ArrayList<>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public double calculateAverage() {
        if (scores.isEmpty()) return 0.0;
        int total = 0;
        for (int s : scores) total += s;
        return (double) total / scores.size();
    }

    public int getMaxScore() {
        if (scores.isEmpty()) return 0;
        return Collections.max(scores);
    }

    public int getMinScore() {
        if (scores.isEmpty()) return 0;
        return Collections.min(scores);
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + fullName +
               ", Scores: " + scores +
               ", Average: " + String.format("%.2f", calculateAverage()) +
               ", Highest: " + getMaxScore() +
               ", Lowest: " + getMinScore();
    }
}

class ReportCard {
    private List<Learner> learners;

    public ReportCard() {
        learners = new ArrayList<>();
    }

    public void registerLearner(Learner l) {
        learners.add(l);
    }

    public Learner searchLearner(String rollNo) {
        for (Learner l : learners) {
            if (l.toString().contains(rollNo)) return l;
        }
        return null;
    }

    public void showReport() {
        if (learners.isEmpty()) {
            System.out.println("No learners found.");
            return;
        }
        System.out.println("\n===== REPORT CARD =====");
        for (Learner l : learners) {
            System.out.println(l);
        }
    }
}

public class GradeTrackerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ReportCard report = new ReportCard();
        int option;

        do {
            System.out.println("\n===== Grade Tracker Menu =====");
            System.out.println("1. Register Learner");
            System.out.println("2. Enter Scores");
            System.out.println("3. Display Report");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    String roll = input.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fname = input.nextLine();
                    report.registerLearner(new Learner(roll, fname));
                    System.out.println("Learner registered!");
                    break;

                case 2:
                    System.out.print("Enter Roll Number: ");
                    String rid = input.nextLine();
                    Learner learner = report.searchLearner(rid);
                    if (learner == null) {
                        System.out.println("Learner not found!");
                    } else {
                        System.out.print("Enter number of subjects: ");
                        int n = input.nextInt();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter score " + (i + 1) + ": ");
                            int score = input.nextInt();
                            learner.addScore(score);
                        }
                        System.out.println("Scores recorded!");
                    }
                    break;

                case 3:
                    report.showReport();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (option != 4);

        input.close();
    }
}# CodeAlpha_StudentGradeTracker
Java program to manage student grades using OOP concepts. Internship Task 1 - CodeAlpha.
