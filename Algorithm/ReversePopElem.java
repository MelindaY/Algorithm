package Algorithm;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReversePopElem {
	public static ListNode FindKthToTail(ListNode head,int k) {
		if(head==null)
			//throw new RuntimeException("empty list");
			return null;
		int length=1;
		ListNode tail=null;
		tail=head;
		while(tail.next!=null){
			length++;
			tail=tail.next;
		}
		if(k>length)
			throw new ArrayIndexOutOfBoundsException("empty list");
		if(k==length)
			return head;
		int position=length-k+1;
//		ListNode node=new ListNode(0);
		if(position==length)
			return tail;
		for(int i=0;i<position;i++){
			head=head.next;
		}
		/*node.val=head.val;
		if(head.next==null)
			node.next=null;
		else node.next=new ListNode(head.next.val);*/
		return head;
    }
	public static void main(String args[]){
		
		 ListNode node=new ListNode(1);
		 ListNode nodeHead=null;
		 nodeHead=node;
		 for(int i=0;i<21;i++){
			 System.out.print(node.val+" ");
			 node.next=new ListNode(i);
			 node=node.next;
		 }
		 System.out.print(node.val+" ");
		 System.out.println();
		 node.next=null;
		 ListNode nodeResult=null;
		 nodeResult=FindKthToTail(nodeHead,10);
		 System.out.println("val is: "+nodeResult.val);
		
	 }

}
