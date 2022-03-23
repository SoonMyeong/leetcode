package algorithm.day05._876;

import org.junit.jupiter.api.Test;


/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 *
 *
 */

public class Solution {


    public ListNode middleNode(ListNode head) {

        if(head.next == null) {
            return head;
        }

        int size = 1;
        ListNode node = head;
        while(node.next !=null) {
            node = node.next;
            size++;
        }

        for(int i=0; i<size/2; i++) {
            head = head.next;
        }

        return head;
    }

    @Test
    void example() {
        ListNode listNode =
                new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5,null)))));

        ListNode result = middleNode(listNode);

        while(result.next !=null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(result.val);

    }

}
