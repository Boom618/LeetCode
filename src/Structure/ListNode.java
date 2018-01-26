package Structure;

/**
 * Created by boomhe on 2018/1/26.
 * <p>
 * 链表结构
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


    /**
     * 创建链表数据
     *
     * @param data "[1,3,6,8]"
     * @return
     */
    public static ListNode createNode(String data) {
        if (data.isEmpty() && data.equals("[]")) {
            return null;
        }

        int len = data.length();
        String nodeList = data.substring(1, len - 1);

        String[] split = nodeList.split(",");

        ListNode[] listNode = new ListNode[len + 1];
        // 防止 i - 1 数组越界
        listNode[0] = new ListNode(Integer.valueOf(split[0]));
        for (int i = 1; i < split.length; i++) {
            listNode[i] = new ListNode(Integer.valueOf(split[i]));
            listNode[i - 1].next = listNode[i];
        }

        return listNode[0];
    }

    /**
     * 打印输出
     *
     * @param listNode
     */
    public static void pritn(ListNode listNode) {
        if (listNode == null) {
            System.out.println("null");
            return;
        }

        // 用 StringBuffer 输出
        StringBuffer sb = new StringBuffer("[" + String.valueOf(listNode.val));

        ListNode p = listNode.next;
        while (p != null) {
            sb.append(",").append(String.valueOf(p.val));
            p = p.next;
        }
        System.out.println(sb.append("]"));
    }
}
