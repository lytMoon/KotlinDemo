public class Test {
    public int a=0;
    public static void main(String[] args) {



    }

    /**
     * 这里使用了synchronized关键字修饰
     */
    public synchronized void sum(){
        a++;
    }


}
