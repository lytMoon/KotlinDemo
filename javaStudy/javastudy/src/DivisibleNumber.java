import java.util.Scanner;

public class DivisibleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number:");
        int inputNumber = scanner.nextInt();
        if (inputNumber == 0) {
            System.out.println("输入的数不能为0");
        } else {
            for (int n = 100; n <= 999; n++) {
                if (n % inputNumber == 0 && (n / 100) % inputNumber == 0 && (n / 10 % 10) % inputNumber == 0 && (n % 10) % inputNumber == 0) {
                    System.out.println(n);
                }
            }
        }
        scanner.close();
    }
}
