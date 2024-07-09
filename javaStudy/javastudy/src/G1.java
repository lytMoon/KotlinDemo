public class G1 {
    public static void main(String[] args) {
        Goods.CheapGoods cheapGoods = new Goods.CheapGoods();
        cheapGoods.newSetWeight(198);
        cheapGoods.oldSetWeight(198.987);
        System.out.println(cheapGoods.oldGetPrice());
    }

}
