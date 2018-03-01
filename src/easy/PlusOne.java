package easy;

/**
 * Created by boomhe on 2018/3/1.
 */
public class PlusOne {

    /**
     * 一个数字数组，高位在前，并且首位不为 0 ，求该数组低位加一的结果
     *
     * @param args
     */
    public static void main(String[] args) {
        PlusOne main = new PlusOne();
        int[] temp = new int[]{8, 9, 9};
        int[] ints = main.plusOne(temp);
        System.out.println("得到的结果是 ：" + ints);

    }


    /**
     * 思路：大于 9 前位加一即可、
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        if (digits[p] < 9) {
            digits[p]++;
        } else {
            while (p != 0 && digits[p] >= 9) {
                digits[p] = 0;
                p--;
                digits[p]++;
            }

            if (p == 0) {
                // 899 => 999 返回即可
                if (digits[p] == 9) {
                    return digits;
                }
                // 999 => 1000
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
