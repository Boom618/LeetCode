package easy;

/**
 * Created by boomhe on 2018/1/22.
 */
public class CommonPrefix {

    /**
     * 从字符串数组中找出公共前缀
     * string[] { "abcc","abde","ab" } => ab
     *
     * @param args
     */
    public static void main(String[] args) {
        CommonPrefix main = new CommonPrefix();
        String[] str = {"abcde", "abcd", "abddddd"};
        String s = main.commonPrefix(str);

        System.out.println(" 公共前缀是 = " + s);

    }

    /**
     * 思路：
     *
     * @param string
     */
    public String commonPrefix(String[] string) {

        String temp = "";

        int strLength = string.length;
        if (strLength == 0) {
            return "";
        } else if (strLength == 1) {
            return string[0];
        }
        int minLength = string[0].length();

        // 获取最短的字符长度(字符串只要比较 minLength 次)
        for (String s : string) {
            minLength = Math.min(s.length(), minLength);
        }

        // string[] { "abc","abd","ab" } => ab
        /* 局限性：
        // 此循环只适用前缀都在相同下标、后面的字符长度不能大于前面的长度
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strLength; j++) {
                if (string[0].charAt(j) != string[i].charAt(j)) {
                    temp = string[0].substring(0,j);
                }
            }
        }*/


        String minString = "";
        // 获取最短字符的字符串（用这个字符串作为模版去匹配）
        for (int i = 0; i < strLength; i++) {
            if (string[i].length() == minLength) {
                minString = string[i];
            }
        }

        // str = {"abcde", "abcd", "abddddd"}
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j <= strLength; j++) {
                if (i < strLength){
                    char at = minString.charAt(j);
                    char c = string[i].charAt(j);
                    if (at != c) {
                        temp = minString.substring(0, j);
                    }
                }
            }
        }


        return temp;


    }
}
