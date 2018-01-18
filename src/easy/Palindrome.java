package easy;

/**
 * Created by boomhe on 2018/1/18.
 */
public class Palindrome {

    /**
     * 判断一个有符号整型数是否是回文，
     * 也就是逆序过来的整数和原整数相同，首先负数肯定不是
     * <p>
     * 12321 => true
     * 12312 => false
     *
     * @param args
     */
    public static void main(String[] args) {
        Palindrome main = new Palindrome();
        int target = 12321;
        int pDrome01 = main.isPalindrome01(target);
        Boolean pDrome02 = main.isPalindrome02(target);

        System.out.println("目标数是 = " + target);
        System.out.println("回文数是01 = " + pDrome01);
        System.out.println("回文数是02 = " + pDrome02);


    }

    /**
     * 思路1 : 推算出回文数 和 原数比较
     * 【 可以参考 Reverse 类 给你一个整型数，求它的逆序整型数 】
     *
     * @param number
     * @return 回文数
     */
    public int isPalindrome01(int number) {
        if (number <= 0) {
            return 0;
        }
        int temp = 0;
        // 出错笔记：(number / 10 != 0) 条件会少算一次
        while (number != 0) {
            temp = 10 * temp + number % 10;
            number /= 10;
        }
        return temp;
    }

    /**
     * 思路2 ：
     * 比如 1234321 我们只需要计算一半的长度即可，
     * 就是在计算过程中的那个逆序数比不断除 10 的数大就结束计算即可
     * 对于 10 的倍数我们需要特需处理下 10010
     *
     * @param number
     * @return 回文数
     */
    public Boolean isPalindrome02(int number) {

        if (number < 0 || (number != 0 && number % 10 == 0)) {
            return false;
        }
        int temp = 0;
        // number 数每次缩小 10 陪、temp 数每次增大 10 陪
        // number 数小于 temp 数时正好计算了一半
        while (number > temp) {
            temp = temp * 10 + number % 10;
            number /= 10;
        }

        // 如果是回文数：
        // 双数位 1221 : temp 和 number 相等
        // 基数位 12321: temp/10 和 number 相等
        boolean b = temp == number || temp / 10 == number;

        return b;
    }


}
