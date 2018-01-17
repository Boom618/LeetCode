package easy;

/**
 * Created by boomhe on 2018/1/16.
 */
public class Reverse {


    /**
     * Input:   123
     * Output:  321
     * 给你一个整型数，求它的逆序整型数
     *
     * @param args
     */
    public static void main(String[] args) {
        Reverse main = new Reverse();
        int reverse = main.reverse(1203);
        System.out.println(" reverse = " + reverse);
        System.out.println(" reverse = " + main.reverse(-9876));
    }

    /**
     * 当它的逆序整型数溢出的话，那么就返回 0
     * 我们求得结果保存在 long 中
     *
     * @param number
     * @return
     */
    public int reverse(int number) {

        long target = 0L;

        for (; number != 0; number /= 10) {
            target = target * 10 + number % 10;
        }
        target = target > Integer.MAX_VALUE || target < Integer.MIN_VALUE ? 0 : target;

        return (int) target;
    }
}
