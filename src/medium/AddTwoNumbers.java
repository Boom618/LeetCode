package medium;

import structure.ListNode;

/**
 * Created by boomhe on 2018/2/8.
 */
public class AddTwoNumbers {

    /**
     * 以链表表示一个数，低位在前，高位在后
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * return: 7 -> 0 -> 8
     * <p>
     * 342 + 465 = 807.
     *
     * @param args
     */
    public static void main(String[] args) {
        AddTwoNumbers main = new AddTwoNumbers();
        ListNode l1 = ListNode.createNode("[1,7,3]");
        ListNode l2 = ListNode.createNode("[5,4,8]");

        ListNode.print(l1);
        ListNode.print(l2);

        ListNode sum = main.addTwoNumbers(l1, l2);
        System.out.print("结果是 ：");
        ListNode.print(sum);
    }


    /**
     * 思路 ：链表对应的节点累加起来、
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode n1 = l1, n2 = l2, temp = node;
        int sum = 0;
        while (n1 != null || n2 != null) {
            // 当 sum 满 10 时、sum 进一位
            sum = sum / 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }

            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            // 判断 sum 累加的数大于 10、存放在 temp 的 next 节点上
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        // 如果最后一位 sum 大于 10 temp 还需指向下一个节点 值 肯定就是 1。
        if (sum / 10 != 0) {
            temp.next = new ListNode(1);
        }

        // node 包括初始值 0 的节点、所以从下一个节点开始返回
        // return node;
        return node.next;
    }
}
