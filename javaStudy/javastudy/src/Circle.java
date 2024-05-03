import java.util.Scanner;

class Circle {
    private double radius;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        circle.disp();
    }

    public Circle() {
        this.radius = 0;
    }

    public Circle(double r) {
        this.radius = r;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void disp() {
        System.out.printf("radius=%.4f\n", radius);
        System.out.printf("perimeter=%.4f\n", getPerimeter());
        System.out.printf("area=%.4f\n", getArea());
    }
}

