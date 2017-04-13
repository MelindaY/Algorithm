package Algorithm;
/*
 * 题目要求：输出链表的倒数第k个元素
 * 想法：       一个引用指向头，一个引用指向尾巴，然后先计算链表长度。
 *        输出倒数第k个元素，就是链表长度-k+1
 * 特殊用例：链表为空;k>链表长度 k<0(当时没想到)
 * 看别人的：一个指向头，一个指向尾。先将头平移k位。然后头不为空时，移动尾部
 * 重要点：   如果只是创建引用，那么初始化为null之后，直接指向对象的引用。
 *        使用new是为了开辟内存空间。对于一个new过之后的元素，你让它与链表相等很麻烦（遍历所有）
 *        为什么这里指向对象引用之后，头引用变化后，同样指向尾部的引用不变？
 *        因为引用指向对象的第一个元素
 *        可以对比ParitySort里面对于数组的引用和赋值
 * */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReversePopElem {
	public static ListNode FindKthToTail(ListNode head,int k) {
		if(head==null||k<0)
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
