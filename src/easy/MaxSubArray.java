package easy;


/**
 * Created by boomhe on 2018/2/6.
 */
public class MaxSubArray {

    /**
     * 求数组中子数组的最大和
     * [-2,1,-3,4,-1,2,1,-5,4]
     * [4,-1,2,1] = 6
     *
     * @param args
     */
    public static void main(String[] args) {
        MaxSubArray main = new MaxSubArray();
        int[] ints = new int[]{-2, 1, -3, 4, -1, -1, -1, 5, -4};
        int[] int1 = new int[]{2, -1, 3};
        int max = main.maxSubArray01(ints);
        int max1 = main.maxSubArray02(int1);
        System.out.println("最大数 max 是 ： " + max);
        System.out.println("最大数 max1 是 ： " + max1);

    }

    /**
     * 思路 1 ：这种最优问题首先想到的是动态规划、当部分序列和大于零就一直累加下一个元素即可、
     * 并和当前最大值进行比较，如果出现部分序列小于零的情况，那肯定就是从当前元素算起。
     * 其转移方程就是 dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
     * <p>
     * 由于我们不需要保留 dp 状态，故可以优化空间复杂度为 1，
     * 即 dp = nums[i] + (dp > 0 ? dp : 0);
     *
     * @param nums
     * @return
     */
    public int maxSubArray01(int[] nums) {
        int length = nums.length;
        int dp = nums[0];
        int max = dp;

        for (int i = 1; i < length; i++) {
            int temp = dp > 0 ? dp : 0;
            dp = nums[i] + temp;
            if (dp > max) {
                max = dp;
            }
        }

        return max;
    }

    /**
     * 思路 2 ：分治、所谓分治就是把问题分割成更小、最后在合并即可。
     * 我们把 nums 一分为二：就有两种情况、最大序列包括中间的值
     * 一种就是不包括、也可以理解成在左边与在右边。当最大序列在中间
     * 的时候我们就把它两侧的最大值算出来、在两侧的的话就继续分治、
     *
     * @param nums
     * @return
     */
    public int maxSubArray02(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }


    private int helper(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) >> 1;

        // 分别递归找到左右两边的最大数
        int leftAnd = helper(nums, left, mid);
        int rightAnd = helper(nums, mid + 1, right);

        int leftMax = nums[mid];
        int rightMax = nums[mid + 1];

        int temp = 0;
        for (int i = mid; i >= left; --i) {
            // 遍历计算最大数
            temp = temp + nums[i];
            if (temp > leftMax) {
                leftMax = temp;
            }
        }
        temp = 0;
        for (int i = mid + 1; i < right; ++i) {
            // 遍历计算最大数
            temp = temp + nums[i];
            if (temp > rightMax) {
                rightMax = temp;
            }
        }
        int maxSub = Math.max(leftAnd, rightAnd);
        int max = Math.max(maxSub, leftMax + rightMax);

        return max;
    }

}
