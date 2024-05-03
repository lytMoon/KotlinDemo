import java.util.Scanner;

class Employee {
    private String name;
    private int age;
    private double baseIncome;
    private double bonusIncome;

    public Employee(String name, int age, double baseIncome, double bonusIncome) {
        this.name = name;
        this.age = age;
        this.baseIncome = baseIncome;
        this.bonusIncome = bonusIncome;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getTotalIncome() {
        return baseIncome + bonusIncome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the employee's name: ");
        String name = scanner.nextLine();

        System.out.println("Please input the employee's age: ");
        int age = scanner.nextInt();

        System.out.println("Please input the employee's sarary: ");
        double baseIncome = scanner.nextDouble();

        System.out.println("Please input the employee's bonus: ");
        double bonusIncome = scanner.nextDouble();

        Employee employee = new Employee(name, age, baseIncome, bonusIncome);

        System.out.println("Employee's name: " + employee.getName());
        System.out.println("Employee's age: " + employee.getAge());
        System.out.println("Employee's income: " + employee.getTotalIncome());
    }


}
