import java.util.Scanner;

class NegativeException extends Exception {
    public NegativeException(String message) {
        super(message);
    }
}

class ZeroException extends Exception {
    public ZeroException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please input first number: ");
            double num1 = scanner.nextDouble();
            System.out.println("Please input second number: ");
            int num2 = scanner.nextInt();

            if (num2 < 0) {
                throw new NegativeException("The divisor, " + num2 + ", could not be negative!");
            } else if (num2 == 0) {
                throw new ZeroException("The divisor, 0,could not be zero!");
            }

            double result = num1 / num2;
            System.out.println("Divisor is : " + result);
        } catch (NegativeException e) {
            System.out.println(e.getMessage());
        } catch (ZeroException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally!");
        }
    }
}
