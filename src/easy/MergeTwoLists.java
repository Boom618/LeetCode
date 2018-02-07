package easy;

import structure.ListNode;


/**
 * Created by boomhe on 2018/1/26.
 */
public class MergeTwoLists {

    /**
     * 合并已排序的链表
     *
     * @param args
     */
    public static void main(String[] args) {
        MergeTwoLists main = new MergeTwoLists();
        ListNode l1 = ListNode.createNode("[1,3,5,6,9]");
        ListNode l2 = ListNode.createNode("[2,4,7,10]");

        ListNode.pritn(l1);
        ListNode.pritn(l2);

        ListNode listNode = main.mergeTwoLists(l1, l2);
        ListNode.pritn(listNode);

    }


    /**
     * 思路：用一个新的链表存放合并后的链表、新的链表指向值小的节点
     * 依次比较、当一条链表为空、直接指向不为空的节点即可
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            // 指向到链表中
            temp = temp.next;
        }

        // 错误笔记： temp = null ? l1 : l2;
        temp.next = l1 != null ? l1 : l2;

        return head;
    }
}
