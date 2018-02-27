package medium;

/**
 * Created by boomhe on 2018/2/26.
 */
public class MaxSubString {

    /**
     * 计算不带重复字符的最长子字符串的长度
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * continue：结束的是本层的本次循环
         * break：结束的是本层循环
         * return:结束的是当前方法
         */
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                continue;
            }
            System.out.print(i + "    ");
        }

        MaxSubString main = new MaxSubString();
        String str = "pwwkew";
        int maxSub = main.maxSubString(str);
        System.out.println("最大子字符串长度是 ： " + maxSub);
    }


    /**
     * 思路：开辟一个数组来存该字符上次除出现的位置遍历、索引做差即最大长度
     *
     * @param str
     * @return
     */
    public int maxSubString(String str) {
        int len;
        if (str.isEmpty() || (len = str.length()) == 0) {
            return 0;
        }
        int preP = 0, max = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            int l = i - preP + 1;
            hash[c] = i + 1;
            if (l > max) {
                max = l;
            }
        }

        return max;
    }
}
