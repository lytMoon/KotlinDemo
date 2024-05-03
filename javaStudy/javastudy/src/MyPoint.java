import java.util.Scanner;

class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the horizontal (X) : ");
        double x = scanner.nextDouble();

        System.out.println("Please input the ordinate (Y) : ");
        double y = scanner.nextDouble();

        MyPoint point = new MyPoint(x, y);

        System.out.println("Your location of horizontal (X) is :" + point.getX());
        System.out.println("Your location of ordinate (Y) is :" + point.getY());
    }


}

