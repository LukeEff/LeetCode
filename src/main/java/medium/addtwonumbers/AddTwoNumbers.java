package medium.addtwonumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return reverseNode(mergeNodeLists(l1,l2));
        }

        //Merges the ListNodes.
        private ListNode mergeNodeLists(ListNode l1, ListNode l2) {
            ListNode holder = null;
            int leftOver = 0;
            while(l1 != null || l2 != null) {
                final int sum = getListValue(l1) + getListValue(l2) + leftOver;
                holder = new ListNode(sum % 10, holder);
                leftOver = sum / 10;

                l1 = getNext(l1);
                l2 = getNext(l2);
            }

            if(leftOver > 0) {
                return new ListNode(leftOver, holder);
            } else {
                return holder;
            }

        }

        //Reverses the order of the sum ListNode
        private ListNode reverseNode(ListNode holder) {
            ListNode reversed = null;
            while(holder != null) {
                reversed = new ListNode(getListValue(holder), reversed);
                holder = getNext(holder);
            }
            return reversed;
        }

        //Returns 0 instead of throwing npe when attempting list.val
        private int getListValue(ListNode list) {
            if(list != null) {
                return list.val;
            }
            return 0;
        }

        //Returns null instead of throwing NPE when attempting list.next
        private ListNode getNext(ListNode list) {
            if(list != null) {
                return list.next;
            }
            return null;
        }



    }
