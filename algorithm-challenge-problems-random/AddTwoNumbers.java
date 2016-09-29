package practice;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        if(l1 == null && l2 == null){
            return sum;
        }
        else if(l1 == null && l2 != null){
            sum = l2;
        }
        else if(l1 != null && l2 == null)
            sum = l1;
        else{
            ListNode head1 = l1;
            ListNode head2 = l2;
            ListNode runner = head1;
            int count1 = 0;
            int count2 = 0;
            while(runner != null){
                count1++;
                runner = runner.next;
            }
            runner = head2;
            while(runner != null){
                count2++;
                runner = runner.next;
            }
            if(count1<count2){
                runner = head1;
                while(runner.next != null){
                    runner = runner.next;
                }
                while(count1 != count2){
                    ListNode zero = new ListNode(0);
                    runner.next = zero;
                    runner = runner.next;
                    count1++;
                }
            }
            else if(count1>count2){
                runner = head2;
                while(runner.next != null){
                    runner = runner.next;
                }
                while(count1 != count2){
                    ListNode zero = new ListNode(0);
                    runner.next = zero;
                    runner = runner.next;
                    count2++;
                }
            }
            ListNode pointer = new ListNode(0);
            pointer = sum;
            int carry = 0;
            while(head1.next!=null){
                pointer.val = head1.val + head2.val + carry;
                carry = 0;
                if(pointer.val>9){
                    carry = 1;
                    pointer.val-=10;
                }
                head1 = head1.next;
                head2 = head2.next;
                ListNode nextelem = new ListNode(0);
                pointer.next = nextelem;
                pointer = nextelem;
            }
            pointer.val = head1.val + head2.val + carry;
            if(pointer.val>9){
                pointer.val -= 10;
                ListNode nextelem = new ListNode(1);
                pointer.next = nextelem;
            }
        }
        return sum;        
    }
	
	public static void main(String[] args){
		AddTwoNumbers obj = new AddTwoNumbers();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(0);
		ListNode runner = new ListNode(8);
		l1.next = runner;
		obj.addTwoNumbers(l1, l2);
	}
}
