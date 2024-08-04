public class VolatileDemo {
    //使用volatile修饰变量
    private static volatile boolean isStop = false;
    public static void stopIt(){
        isStop = true;
    }

    public static void main(String[] args) {
        new Thread1().start();
        while (!isStop){
        }
        System.out.println("stop!!!");
    }

    /**
     * 这里的预期结果是  加上volatile 的话三秒后循环截止，不加volatile 则会一直陷入循环
     *  volatile保证了内存的可见性
     *  也就是说isStop会及时更新为最新的值，多线程之间的值是共享一致的
     *  但是不加的话就会导致 用到自己线程的缓存，也就是一直会为false
     *  具体请看这里https://www.cnblogs.com/wk-missQ1/p/12889974.html
     *  volatile关键字的试用范围
     *  　　　1、对变量的写操作不依赖当前变量的值；
     * 　　 　2、该变量没有包含在其他变量的不变式中。
     */
    static class Thread1 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopIt();
        }
    }

}