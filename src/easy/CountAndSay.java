package easy;

/**
 * Created by boomhe on 2018/2/5.
 */
public class CountAndSay {


    /**
     * 统计出现的数字 + 说出来
     * 比如：122 ： 1122 ( 一个 1 两个 2)
     *
     *      1.     1
     *      2.     11
     *      3.     21
     *      4.     1211
     *      5.     111221
     *
     * @param args
     */
    public static void main(String[] args) {
        CountAndSay main = new CountAndSay();
        String str = main.countAndSay(5);
        System.out.println("统计的数是 ：" + str);

    }

    /**
     * 思路：初始值是 1 开始
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        // 初始值从 1 开始
        String str = "1";

        while (--n > 0) {
            // sb 每次都要用新的、才能保证数据不重叠
            StringBuffer sb = new StringBuffer();
            char[] chars = str.toCharArray();
            int length = chars.length;

            // 统计不同数的次数
            int times = 1;
            for (int j = 1; j < length; j++) {
                if (chars[j - 1] == chars[j]) {
                    times++;
                } else {
                    sb.append(times).append(chars[j - 1]);
                    // 错误笔记：times 重置 1
                    times = 1;
                }
            }

            // sb 每循环一次都是新的、值保存在 str 中
            str = sb.append(times).append(chars[length - 1]).toString();
        }

        return str;
    }
}
