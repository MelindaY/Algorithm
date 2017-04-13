package Algorithm;
/*
 * ��Ŀ������һ��������ת�����������������Ԫ�ء�
 * ˼���������Ŀ���е��Ʋ������ˣ���Ҫ����Ϊһֱ������ָ�룬ʵ�����õĶ������е�㲻����
 *     ���������á�һ����head��һ����pre��һ����next
 *     1. nextָ��head.next,����nextָ��head����һ��Ԫ�ء�pre��ʼ��Ϊnull
 *     2. head.nextָ��pre
 *     3. preָ��head
 *     3.Ȼ����head=next��Ҳ����head��ǰ��һ��
 *     ֱ��headΪ�ս���ѭ��
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
	 

