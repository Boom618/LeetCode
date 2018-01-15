package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by boomhe on 2018/1/15.
 */
public class TwoSum {

    /**
     * 从给定的数组中找到两个元素的和为指定值的两个索引
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] ints = {2, 5, 7, 9, 12};
        TwoSum main = new TwoSum();
        //int[] twoSum = main.twoSum01(ints, 17);
        int[] twoSum = main.twoNum02(ints, 17);
        System.out.println("twoSum = " + Arrays.toString(twoSum));
    }



    /**
     * 实现方式 一： 双循环
     *
     * @param nums   nums = [2, 7, 11, 15]
     * @param target 9
     * @return [0, 1]
     */
    public int[] twoSum01(int[] nums, int target) {
        int length = nums.length;
        if (length < 2) {
            return null;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /**
     * 实现方式 二 ：HashMap  map.containsKey
     *
     * 利用 HashMap 作为存储，键为 目标值 减 当前元素值，索引为值
     *
     * @param nums   nums = [2, 7, 11, 15]
     * @param target 9
     * @return [0, 1]
     */
    public int[] twoNum02(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i], i);
        }

        return null;
    }
}
