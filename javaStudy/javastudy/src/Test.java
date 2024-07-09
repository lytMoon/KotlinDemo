public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {100, 200, 300};
        System.out.println(a == b);//【代码1】false
        a = b;
//【代码 2】
        System.out.println("数组 a的元素个数=" + a.length);  //3
//【代码3】
        System.out.println("数组b的元素个数=" + b.length); //3
        System.out.println("a[1]=" + a[1]);//【代码 4】200
//【代码5】
        System.out.print("b[1]=" + b[1]);//200
    }
}