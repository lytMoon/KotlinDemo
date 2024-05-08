import java.util.HashMap;

public class HorsePool {
    public static int horsePool(String text, String pattern) {
        int n = text.length(); // 文本串长度
        int m = pattern.length();// 模式串长度
        if (m == 0) {
            return 0;// 如果模式串为空，直接返回0
        }
        // 创建跳转表，记录模式串中每个字符最后出现的位置
        HashMap<Character, Integer> last = new HashMap<>();
        for (int k = 0; k < m; k++) {
            last.put(pattern.charAt(k), k);
        }

        int i = m - 1;// 文本串中与模式串最右端字符对应的位置
        int k = m - 1;// 模式串中最右端字符的位置05
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(k)) { // 当前字符匹配
                if (k == 0) {
                    return i;// 找到匹配，返回模式串在文本串中的起始位置
                } else {
                    i -= 1;// 向左移动比较点
                    k -= 1;// 模式串的比较点也向左移动
                }
            } else {
                // 不匹配时，根据跳转表决定下一步的移动
                int j = last.containsKey(text.charAt(i)) ? last.get(text.charAt(i)) : -1;
                i += m - Math.min(k, j + 1);// 计算跳过的字符数，如果上面j为-1，也就是目标串中不含有不匹配的i对应的char，那么直接移动整个长度m
                k = m - 1;//重置模式串的比较点
            }
        }
        return -1;// 如果没有找到匹配，返回-1
    }

    public static void main(String[] args) {
        String text = "i love android";
        String pattern1 = "android";
        System.out.println(horsePool(text, pattern1));

        String pattern2 = "kotlin";
        System.out.println(horsePool(text, pattern2));
    }
}
