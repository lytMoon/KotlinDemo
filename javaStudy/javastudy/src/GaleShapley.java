/**
 * todo:稳定婚姻算法 -- Gale-Shapley 算法
 * description：
 *  这个类实现了Gale-Shapley算法来找到稳定的匹配。
 *  在这个问题中，每个男人和每个女人都有他们偏好的异性列表。
 *  算法的目标是确保所有的匹配都是稳定的，没有任何人更愿意与当前伴侣以外的人配对。
 */
public class GaleShapley {
    // N代表参与匹配的男性和女性的数量。
    private final int N;
    // engagedCount记录已经订婚的男性数量。
    private int engagedCount;
    // menPref和womenPref分别存储每个男性和女性的偏好列表。
    private final String[][] menPref;
    private final String[][] womenPref;
    // men和women数组分别存储所有男性和女性的名字。
    private final String[] men;
    private final String[] women;
    // womenPartner数组存储每个女性当前的伴侣。
    private final String[] womenPartner;
    // menEngaged数组标记每个男性是否已经订婚。
    private final boolean[] menEngaged;

    /**
     * 构造函数初始化所有的变量。
     *
     * @param m  男性名字数组
     * @param w  女性名字数组
     * @param mp 男性偏好列表
     * @param wp 女性偏好列表
     */
    public GaleShapley(String[] m, String[] w, String[][] mp, String[][] wp) {
        N = mp.length;
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
        calcMatches();
    }

    /**
     * calcMatches方法执行Gale-Shapley算法来找到稳定的匹配。
     */
    private void calcMatches() {
        // 当还有未订婚的男性时，继续寻找匹配。
        while (engagedCount < N) {
            int free;
            // 找到第一个未订婚的男性。
            for (free = 0; free < N; free++)
                if (!menEngaged[free]) break;
            // 遍历这个男性的偏好列表。
            for (int i = 0; i < N && !menEngaged[free]; i++) {
                // 获取当前偏好女性的索引。
                int index = womenIndexOf(menPref[free][i]);
                // 如果这个女性还没有伴侣，就与她订婚。
                if (womenPartner[index] == null) {
                    womenPartner[index] = men[free];
                    menEngaged[free] = true;
                    engagedCount++;
                } else {
                    // 如果这个女性已经有伴侣，检查她是否更喜欢当前的男性。
                    String currentPartner = womenPartner[index];
                    if (morePreference(currentPartner, men[free], index)) {
                        // 如果是，改变她的伴侣。
                        womenPartner[index] = men[free];
                        menEngaged[free] = true;
                        menEngaged[menIndexOf(currentPartner)] = false;
                    }
                }
            }
        }
        // 打印最终的匹配结果。
        printCouples();
    }

    /**
     * morePreference方法检查一个女性是否更喜欢新伴侣而不是当前伴侣。
     *
     * @param curPartner 当前伴侣
     * @param newPartner 新伴侣
     * @param index      女性的索引
     * @return 如果女性更喜欢新伴侣，返回true。
     */
    private boolean morePreference(String curPartner, String newPartner, int index) {
        for (int i = 0; i < N; i++) {
            if (womenPref[index][i].equals(newPartner)) return true;
            if (womenPref[index][i].equals(curPartner)) return false;
        }
        return false;
    }

    /**
     * menIndexOf方法返回一个男性在数组中的索引。
     *
     * @param str 男性的名字
     * @return 男性的索引
     */
    private int menIndexOf(String str) {
        for (int i = 0; i < N; i++)
            if (men[i].equals(str)) return i;
        return -1;
    }

    /**
     * womenIndexOf方法返回一个女性在数组中的索引。
     *
     * @param str 女性的名字
     * @return 女性的索引
     */
    private int womenIndexOf(String str) {
        for (int i = 0; i < N; i++)
            if (women[i].equals(str)) return i;
        return -1;
    }

    /**
     * printCouples方法打印所有的匹配结果。
     */
    public void printCouples() {
        System.out.println("Couples are : ");
        for (int i = 0; i < N; i++) {
            System.out.println(womenPartner[i] + " " + women[i]);
        }
    }

    //程序测试入口
    public static void main(String[] args) {

        String[] men = {"A", "B", "C", "D"};
        String[] women = {"E", "F", "G", "H"};
        String[][] menPref = {{"E", "F", "G", "H"}, {"G", "E", "H", "F"}, {"F", "H", "E", "G"}, {"H", "G", "F", "E"}};
        String[][] womenPref = {{"D", "B", "C", "A"}, {"C", "A", "D", "B"}, {"A", "D", "B", "C"}, {"B", "C", "A", "D"}};

        new GaleShapley(men, women, menPref, womenPref);

    }

}
