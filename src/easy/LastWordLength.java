package easy;

/**
 * Created by boomhe on 2018/2/28.
 */
public class LastWordLength {

    /**
     * 从一个只包含大小字母和空格字符的字符串中得到最后一个单词的长度
     *
     * @param args
     */
    public static void main(String[] args) {
        LastWordLength main = new LastWordLength();
        String s = "Hello World";
        int length = main.lastWordLength(s);
        System.out.println("最后一位单词的长度是 ：" + length);

    }


    /**
     * 思路：总长度减去 遍历不为空的字符位置、
     *
     * @param s
     * @return
     */
    public int lastWordLength(String s) {
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }
        int end = p;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
        }

        // API 实现
        // return s.trim().length() - s.trim().lastIndexOf(" ") - 1;

        return end - p;
    }

}
