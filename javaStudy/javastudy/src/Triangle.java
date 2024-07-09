import java.util.Scanner;

public class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void setSide(double x, double y, double z) {
        if (x + y > z && x + z > y && y + z > x) {
            this.a = x;
            this.b = y;
            this.c = z;
        } else {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        in.close();

        Triangle triangle = new Triangle(a, b, c);
        double perimeter = triangle.getPerimeter();
        double area = triangle.getArea();

        System.out.printf("perimeter=%.1f\n", perimeter);
        System.out.printf("area=%.1f\n", area);
        System.out.printf("a=%.1f,b=%.1f,c=%.1f\n", triangle.a, triangle.b, triangle.c);
    }
}
