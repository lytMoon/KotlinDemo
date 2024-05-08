import java.math.BigInteger;
import java.util.Scanner;

public class DecimalToFraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        // 分离整数和小数部分
        String[] parts = input.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);
        int decimalPart = Integer.parseInt(parts[1]);

        // 计算小数部分的长度
        int decimalLength = parts[1].length();

        // 分母为10的decimalLength次方
        int denominator = (int) Math.pow(10, decimalLength);

        // 创建分数并约分
        BigInteger numerator = BigInteger.valueOf(decimalPart);
        BigInteger bigDenominator = BigInteger.valueOf(denominator);
        BigInteger gcd = numerator.gcd(bigDenominator);

        // 得到最简分数
        numerator = numerator.divide(gcd);
        bigDenominator = bigDenominator.divide(gcd);

        // 输出结果
        System.out.println(integerPart + " " + numerator + " " + bigDenominator);
    }
}
