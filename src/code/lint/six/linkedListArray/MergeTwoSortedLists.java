package code.lint.six.linkedListArray;

/**
 * Created by 505007855 on 9/25/2017.
 */
public class MergeTwoSortedLists {

    /*
    *
    * Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Have you met this question in a real interview? Yes
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
    *
    * */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here

       /* if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null && l2 != null){
            return l2;
        }

        if(l1 != null && l2 == null){
            return l1;
        }

        ListNode currentL1 = l1;
        ListNode nextL1 = l1.next;

        ListNode currentL2 = l2;
        ListNode nextL2 = l2.next;

        ListNode resultNode = null;


        if(currentL1.val <= currentL2.val && currentL2.val < nextL1.val){
            resultNode.val = currentL1.val;
            resultNode.next = currentL2;
        }
        */


       ListNode dummy = new ListNode(0);
       ListNode lastNode = dummy;


       while(l1 != null && l2 != null){

           if(l1.val < l2.val){
               lastNode.next = l1;
               l1 = l1.next;
           }else {
               lastNode.next = l2;
               l2 = l2.next;
           }

           lastNode = lastNode.next;
       }

       if(l1 != null){
           lastNode.next = l1;
       }else{
           lastNode.next = l2;
       }

       return dummy.next;
    }



    // JIU ZHANG's Answer
    /*
    *
    * public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }
}
    *
    * */


    // Shuo Chang's Answer
    /*
    *
    * public class Solution {
    //
    // @param ListNode l1 is the head of the linked list
    // @param ListNode l2 is the head of the linked list
    // @return: ListNode head of linked list
    //
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy =new ListNode(0);
        ListNode curt = dummy;
        if (l1 == null && l2 ==null){
            return null;
        }
        while (l1 !=null && l2 != null){
            if (l1.val < l2.val){
                curt.next = l1;
                l1 = l1.next;

            } else  {
                curt.next = l2;
                l2 = l2.next;
            }
            curt = curt.next;
        }

        if (l1 != null){
            curt.next = l1;
        }
        if (l2 != null){
            curt.next = l2;
        }
        return dummy.next;
    }
}
    *
    * */

}
