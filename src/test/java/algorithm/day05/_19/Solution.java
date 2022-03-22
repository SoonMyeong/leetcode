package algorithm.day05._19;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * 이 문제의 핵심은 노드를 순회하려면 노드 참조 값을 하나 잡아놓고
 * 그 참조된 값으로 순회해야 한다. 원본객체인 head 를 안건드려야 풀 수 있는 문제다.
 * 뭔소리냐면 참조된 값으로 순회하면 head 의 시작점은 변경되지 않는다는 거다.
 * 참조된 값으로 순회하면서 노드 사이의 값을 건드는 것은 원본 역시 변경이 되는데,
 *
 * =>어쨋든간에 원본의 시작점인 head 는 변경하지 않고, 참조된 노드의 시작점을 계속 바꿔가면서 순회 하는 것!
 *
 *
 */

public class Solution {


    // MY Solution
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head.next ==null) {
            return null;
        }

        ListNode node = new ListNode(head.val);
        List<Integer> list = new ArrayList<>();
        while(head.next!=null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        list.remove(list.size()-n);

        ListNode listNode = new ListNode(list.get(0));
        ListNode res = listNode;
        for (int i = 1; i < list.size(); i++) {
            listNode.next = new ListNode(list.get(i));
            listNode = listNode.next;
        };
        return res;
    }

    //refactoring
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next ==null) {
            return null;
        }

        ListNode node = head;
        int size = 1;
        while(node.next!=null) {
            node = node.next;
            size++;
        }

        size = size-n;
        node = head;

        for(int i=0; i<size-1; i++) {
            node = node.next;
        }

        if(size ==0) {
            node = node.next;
            head = node;
            return head;
        }

        node.next = node.next.next;

        return head;

    }

    @Test
    void example() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        int n = 2;

        /** 이거 솔직히 한줄에 다 끝낼 수 있는디.. 걍 두자 */
        listNode1.next = listNode2;

        ListNode result = removeNthFromEnd(listNode1,n);

        while(result.next!=null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
        System.out.println(result.val);
    }

    @Test
    void example2() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        int n = 2;

        /** 이거 솔직히 한줄에 다 끝낼 수 있는디.. 걍 두자 */
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode result = removeNthFromEnd2(listNode1,n);

        while(result.next!=null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
        System.out.println(result.val);
    }

}
