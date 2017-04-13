package Algorithm;
/*
 * 题目：输入一个链表，反转链表后，输出链表的所有元素。
 * 思考：这个题目我有点绕不过来了，主要是因为一直有类似指针，实则引用的东西我有点搞不来啊
 *     用三个引用。一个是head，一个是pre，一个是next
 *     1. next指向head.next,这样next指向head的下一个元素。pre初始化为null
 *     2. head.next指向pre
 *     3. pre指向head
 *     3.然后让head=next，也就是head往前走一步
 *     直到head为空结束循环
 *     
 * */
public class RotateList {
	 public  static ListNode ReverseList(ListNode head) {
		 ListNode next=null;
		 ListNode pre=null;
		 if(head==null)
			 return null;
		 while(head!=null){
			 next=head.next;
			 /*next.next=pre;
			 pre=pre.next;
			 head=head.next;*/
			 head.next=pre;
			 pre=head;
			 head=next;
		 }
		 return pre;
	 }
	 public static void main(String args[]){
			
		 ListNode node=new ListNode(1);
		 ListNode nodeHead=null;
		 nodeHead=node;
		 for(int i=0;i<2;i++){
			 System.out.print(node.val+" ");
			 node.next=new ListNode(i+2);
			 node=node.next;
		 }
		 System.out.println();
		 ListNode nodeReverse=null;
		 nodeReverse=ReverseList(nodeHead);
		 for(int i=0;i<2;i++){
			 if(nodeReverse.next!=null)
			 System.out.print( nodeReverse.val+" ");
			 nodeReverse=nodeReverse.next;
		 }
		 System.out.print( nodeReverse.val+" ");
	 }
}
	 

