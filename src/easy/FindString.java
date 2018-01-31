package easy;

/**
 * Created by boomhe on 2018/1/31.
 */
public class FindString {

    /**
     * 主字符串中找子字符串的索引
     *
     * @param args
     */
    public static void main(String[] args) {
        FindString main = new FindString();
        int subString = main.findSubString("abcdf", "df");
        System.out.println("找到的字符长度的索引是 ： " + subString);
    }


    /**
     * 思路：遍历比较、主串中（i + j）的索引和子串 j 的索引应该保持一致
     * 当子串小于主串直接返回 -1
     *
     * @param haystack 给定字符串
     * @param needle   需要查找字符串
     * @return 没找到返回 -1
     */
    public int findSubString(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1 < l2) {
            return -1;
        }
        // for 循环中第二个参数不写、返回值可以是循环里面的值
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                // 子字符串能找到 返回索引即可
                if (j == l2) return i;

                // 遍历完了、还没找到直接返回 -1
                if (i + j == l1) return -1;

                // break 跳出当前循环、从外循环 i 开始遍历【关键点】
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}
