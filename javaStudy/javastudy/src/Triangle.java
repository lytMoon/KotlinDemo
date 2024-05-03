import java.util.Scanner;

public class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }
    }

    public void setSide(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            System.out.println("a b c input error");
        }
    }

    public void setA(double a) {
        if (isValidTriangle(a, this.b, this.c)) {
            this.a = a;
        } else {
            System.out.println("a input error");
        }
    }

    public void setB(double b) {
        if (isValidTriangle(this.a, b, this.c)) {
            this.b = b;
        } else {
            System.out.println("b input error");
        }
    }

    public void setC(double c) {
        if (isValidTriangle(this.a, this.b, c)) {
            this.c = c;
        } else {
            System.out.println("c input error");
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public String toString() {
        return "a=" + a + ",b=" + b + ",c=" + c;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double z = in.nextDouble();
        Triangle t = new Triangle(x, y, z);
        System.out.printf("perimeter=%.2f\n", t.getPerimeter());
        System.out.printf("area=%.2f\n", t.getArea());
        System.out.println(t);
        t.setSide(t.getA() + 3, t.getB() + 2, t.getC() + 1);
        System.out.println(t);
        t.setA(t.getA() + 20);
        System.out.println(t);
        t.setB(t.getB() + 20);
        System.out.println(t);
        t.setC(t.getC() + 20);
        System.out.println(t);
        in.close();
    }
}
