package Algorithm;
/*
 * ��ĿҪ���������ĵ�����k��Ԫ��
 * �뷨��       һ������ָ��ͷ��һ������ָ��β�ͣ�Ȼ���ȼ��������ȡ�
 *        ���������k��Ԫ�أ�����������-k+1
 * ��������������Ϊ��;k>������ k<0(��ʱû�뵽)
 * �����˵ģ�һ��ָ��ͷ��һ��ָ��β���Ƚ�ͷƽ��kλ��Ȼ��ͷ��Ϊ��ʱ���ƶ�β��
 * ��Ҫ�㣺   ���ֻ�Ǵ������ã���ô��ʼ��Ϊnull֮��ֱ��ָ���������á�
 *        ʹ��new��Ϊ�˿����ڴ�ռ䡣����һ��new��֮���Ԫ�أ���������������Ⱥ��鷳���������У�
 *        Ϊʲô����ָ���������֮��ͷ���ñ仯��ͬ��ָ��β�������ò��䣿
 *        ��Ϊ����ָ�����ĵ�һ��Ԫ��
 *        ���ԶԱ�ParitySort���������������ú͸�ֵ
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
