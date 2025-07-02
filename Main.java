import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Grade Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    Student student = new Student(name, roll);
                    System.out.print("Enter number of subjects: ");
                    int subjects = sc.nextInt();

                    for (int i = 0; i < subjects; i++) {
                        System.out.print("Enter mark for subject " + (i + 1) + ": ");
                        int mark = sc.nextInt();
                        student.addMark(mark);
                    }
                    students.add(student);
                    break;

                case 2:
                    for (Student s : students) {
                        s.displayStudent();
                        System.out.println("-----------");
                    }
                    break;

                case 3:
                    System.out.print("Enter student name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getName().equalsIgnoreCase(searchName)) {
                            s.displayStudent();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
