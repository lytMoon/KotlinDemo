import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many students?");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        ArrayList<String> studentNames = new ArrayList<>();
        if (numStudents != 0) {
            System.out.println("Please input the names of students:");
            for (int i = 0; i < numStudents; i++) {
                String name = scanner.nextLine();
                studentNames.add(name);
            }
        }

        System.out.println("All the students bellow:");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println((i + 1) + ":" + studentNames.get(i));
        }
    }
}
