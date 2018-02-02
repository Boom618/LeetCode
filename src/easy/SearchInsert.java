package easy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by boomhe on 2018/2/2.
 */
public class SearchInsert {

    /**
     * 找到目标数插入的索引
     * Input: [1,3,5,6], 7
     * Output: 4
     *
     * @param args
     */
    public static void main(String[] args) {
        SearchInsert main = new SearchInsert();
        int[] nums = new int[]{1, 4, 7, 9, 12};
        int position = main.searchInsert(nums, 7);
        System.out.println("插入的索引是 ：" + position);

    }


    /**
     * 思路：target 目标数存在 nums 中 Arrays.binarySearch 即可
     * 不存在 nums 中，二分法查找
     *
     * @param nums   排序数组
     * @param target 目标数
     * @return 插入索引
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length <= 0) {
            return 0;
        }
        // 1、如果 target 存在于 nums 数组中直接返回 position 即可
        List<int[]> list = Arrays.asList(nums);
        if (list.contains(target)) {
            // binarySearch 搜索【有序】数组中目标数的位置
            int position = Arrays.binarySearch(nums, target);
            return position;
        }

        // 2、不存在 nums 数组中、插入数组中返回 position
        int left = 0;
        int right = length - 1;
        int mind = (left + right) >> 1;

        // 二分法
        while (left <= right) {
            // 在左边插入、右边最大数左移到 mind - 1 位置
            if (target <= nums[mind]) {
                right = mind - 1;
            } else {
                // 在右边插入、左边最小数右移到 mind + 1 位置
                // 错误笔记 ：left = mind  - 1;
                left = mind + 1;
            }
            mind = (left + right) >> 1;
        }

        return left;
    }
}
