import java.util.*;

class Student {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
        System.out.println("---------------------");
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(roll, name, marks));
                    System.out.println("Student Added!");
                    break;

                case 2:
                    System.out.print("Enter Roll No: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo == searchRoll) {
                            s.display();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found");
                    break;

                case 3:
                    System.out.print("Enter Roll No: ");
                    int deleteRoll = sc.nextInt();

                    students.removeIf(s -> s.rollNo == deleteRoll);
                    System.out.println("Student Deleted");
                    break;

                case 4:
                    for (Student s : students) {
                        s.display();
                    }
                    break;

                case 5:
                    System.out.println("Program Closed");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}