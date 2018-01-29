package easy;

/**
 * Created by boomhe on 2018/1/29.
 */
public class RemoveDuplicates {

    /**
     * 删除有序数组中的重复数据
     * @param args
     */
    public static void main(String[] args) {
        RemoveDuplicates main = new RemoveDuplicates();
        int[] nums = new int[]{1,2,2,3,3,4,5,5};
        int len = main.removeDuplicates(nums);
        System.out.println("更新后的长度是 ：" + len);

    }

    /**
     * 思路：比较前后两个元素是否相等
     * @param nums [1,1,2,3]
     * @return 新数组的长度
     */
    public int removeDuplicates(int[] nums){

        int length = nums.length;
        if (length <= 1) {
            return nums.length;
        }
        // 初始值 从 1 开始累加
        int tail = 1;
        for (int i = 0; i < length -1; i++) {
            if (nums[i] != nums[i + 1] ) {
                tail++;
            }
        }
        return tail;
    }
}
