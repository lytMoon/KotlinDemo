import java.util.Scanner;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input length: ");
        double length = scanner.nextDouble();

        System.out.println("Please input width: ");
        double width = scanner.nextDouble();

        Rectangle rectangle = new Rectangle(length, width);

        System.out.println("The lengh is:" + rectangle.length);
        System.out.println("The width is:" + rectangle.width);
        System.out.println("The area is:" + rectangle.calculateArea());
    }
}