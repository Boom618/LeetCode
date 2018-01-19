package easy;

import java.util.HashMap;

/**
 * Created by boomhe on 2018/1/19.
 */
public class RomanToInt {

    /**
     * 罗马数字转整型数
     * XII = 7
     * IX  = 4
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * DCXXI = 621
         CCDD = 1000
         */
        RomanToInt main = new RomanToInt();
        int toInt = main.romanToInt("DCXXI");
        System.out.println("实际数是01 = " + toInt);
        System.out.println("实际数是02 = " + main.romanToInt("CCDD"));
    }


    /**
     * 思路： 用 HashMap 映射 罗马数 和 实际数
     *
     * @param str
     * @return
     */
    public int romanToInt(String str) {

        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // VII

        int length = str.length() - 1;
        char[] temp = str.toCharArray();

        // 循环遍历取不到最后一位、所以首次就取到最后一位作为初始值
        int number = romanMap.get(temp[length]);

        for (int i = 0; i < length; i++) {
            if (romanMap.get(temp[i]) >= romanMap.get(temp[i + 1])) {
                number += romanMap.get(temp[i]);
            } else {
                // 错误笔记：XL = -40 除第一位外都计算了两次
                // number += romanMap.get(temp[i]) - romanMap.get(temp[i + 1]);
                number -= romanMap.get(temp[i]);
            }
        }

        return number;
    }
}
