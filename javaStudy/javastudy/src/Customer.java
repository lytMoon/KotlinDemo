import java.util.Arrays;

public class Customer implements Comparable<Customer> {
    private String name;
    private double height;
    private double weight;
    private double score;

    public Customer(String name, double height, double weight, double score) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.score = score;
    }

    public String speak() {
        return "I am " + name + ", my height " + height + ", my weight " + weight + ", my score " + score;
    }

    @Override
    public int compareTo(Customer other) {
        double thisValue = height * 0.2 + weight * 0.3 + score * 0.5;
        double otherValue = other.height * 0.2 + other.weight * 0.3 + other.score * 0.5;
        return Double.compare(thisValue, otherValue);
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ",height=" + height + ",weight=" + weight + ",score=" + score + "]";
    }

    // 测试类
    public static void main(String[] args) {
        Customer[] customers = {
                new Customer("zhangsan", 170.0, 110.0, 95.0),
                new Customer("lisi", 168.0, 120.0, 75.0),
                new Customer("wangwu", 165.0, 115.0, 88.0),
                new Customer("zhaoliu", 172.0, 121.0, 90.0),
                new Customer("zhouqi", 160.0, 100.0, 85.0),
                new Customer("zhengba", 166.0, 119.0, 70.0)
        };

        System.out.println("array sort before:");
        for (Customer customer : customers) {
            System.out.println(customer.speak());
        }

        Arrays.sort(customers);

        System.out.println("\narray sort after:");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
}
