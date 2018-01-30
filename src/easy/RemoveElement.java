package easy;

/**
 * Created by boomhe on 2018/1/30.
 */
public class RemoveElement {

    /**
     * 删除指定元素返回新数组的长度
     *
     * @param args
     */
    public static void main(String[] args) {
        RemoveElement main = new RemoveElement();
        int[] nums = new int[]{2, 2, 3, 3, 4, 6, 7, 8, 8, 9};
        int element = main.removeElement(nums, 8);
        System.out.println("新数组的长度是 ：" + element);

    }

    /**
     * 思路：依次遍历，遍历该数组时当索引元素不等于 val 时，temp 加一
     *
     * @param nums
     * @param val
     * @return temp 即可
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                temp++;
            }
        }
        return temp;
    }
}
