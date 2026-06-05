import java.util.Scanner;

public class GradeCalculator {

    static int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    static double calculateAverage(int total, int subjects) {
        return (double) total / subjects;
    }

    static String findGrade(double average) {
        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Marks of Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        int total = calculateTotal(marks);
        double average = calculateAverage(total, n);
        String grade = findGrade(average);

        System.out.println("\n----- RESULT -----");
        System.out.println("Total Marks : " + total);
        System.out.printf("Average : %.2f%%\n", average);
        System.out.println("Grade : " + grade);

        sc.close();
    }
}