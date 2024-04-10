public class Test1 {
    private Test1 test1;

    private Test1() {

    }

    public Test1 getInstance() {
        if (test1 == null) {
            return test1;
        } else {
            test1 = new Test1();
            return  test1;
        }
    }


}
