public class Goods {
    public double weight;

    public void oldSetWeight(double w ) {
        weight = w;
        System.out.println("double 类型的weight"+weight);

    }

    public double oldGetPrice() {
        double price = weight * 10;
        say();
        return price;
    }

    private void say() {
        System.out.println("Buy！Buy！Buy！");
    }

    static class CheapGoods extends Goods {
        public int weight;
        double weightNew = 3.1;

        public void newSetWeight(int w) {
            weight = w;
            System.out.println("int 类型的weight" + weight);


        }

        public double newGetPrice() {
            double price = weight * 10;
            return price;
        }

        public void say() {
            oldSetWeight(newGetPrice());
            System.out.println("买！买！买");
        }
    }




}
