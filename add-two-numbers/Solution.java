class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
	val= x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	int carry = 0;
	ListNode result = new ListNode(0);
	ListNode h = result;

	while (l1 != null && l2 != null) {
	    result.val= l1.val + l2.val + carry;
	    carry = result.val / 10;
	    result.val= result.val % 10;
	    l1 = l1.next;
	    l2 = l2.next;
	    if(l1 != null && l2 != null) {
	        result = result.next = new ListNode(0);
	    }
	    else if(l1 == null && l2 == null && carry > 0) {
	        result = result.next = new ListNode(carry);
	    }
	}
	
	ListNode rest;
	if(l1 == null) {
	    rest = l2;
	}
	else {
	    rest = l1;
	}
    
	while(rest != null) {
	    result = result.next = new ListNode(0);
	    result.val = rest.val + carry;
	    carry = result.val / 10;
	    result.val = result.val % 10;
	    rest = rest.next;
	    if (rest == null && carry > 0) {
		result = result.next = new ListNode(carry);
	    }
	}
    
	return h;
    }
}

