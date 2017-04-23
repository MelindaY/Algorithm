package Algorithm;

import java.util.ArrayList;


class ListNode {
	int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
   }
}
public class SimpleList {

	/*
	 * ��Ŀ��    ���������������������������������ϳɺ������
	 *       ��Ȼ������Ҫ�ϳɺ���������㵥����������
	 *       
	 * ˼����    ˵ʵ�ڵģ���δ���д�����Ǳ�������������ˣ���̬��֮�������ں��ѱ�ȫͷ���úͲ����
	 *       �мǣ�ListNode node=list1;
	 *           �����node.next=list2֮��list1.nextҲ�����list2��
	 *           ���ǿ������۸�node�����ã�����node=list2��ֻҪ����final�ľ��У�
	 *       ��Ϊ�Ҳ�ϲ���ݹ飡NOT AT ALL��
	 *       �����أ�������ǵݹ�ķ�ʽ����ô˵�أ��Ҿ���д��һ��
	 *       ʵ���ǲ����ٿ����˵ķǵݹ�汾����Ѫ
	 ***********************************************************************
	 *       �ݹ鷽�������
	 *       ���棬������õݹ��1���ӡ�������ò�Ʋ�ϰ�ߵݹ��˼ά
	 *           
	 * */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode tmpNode=null;
        ListNode head=list1;
        ListNode next=null;
        ListNode pre=null;
    	if(list1==null&&(list2==null))
        	return null;
        else if(list1==null)
        	return list2;
        else if(list2==null)
        	return list1;
        /*if(list1==null)
        	return null;
        else if(list2==null)
        	return list1;*/
        while(list1.next!=null){
        	//������С��list1������ȫ���嵽list֮ǰ
        	while((list1.val>list2.val)&&(list2.next!=null)){
        		tmpNode=new ListNode(list2.val);
        		tmpNode.val=list2.val;
        		tmpNode.next=list1;
        		next=head;
        		if(head.val>tmpNode.val)//���ǰ��δ�����һ��list2Ԫ��
        			head=tmpNode;
        		else{
        			next=head.next;
        			pre=head;
        			//Ѱ�Ҳ���㣬����¼ǰ��Ԫ�ء�
        			while(next.val<list2.val){
        				pre=pre.next;
            			next=next.next;
            		}
        			pre.next=tmpNode;
        			tmpNode.next=next;
        		}
        		
            	list2=list2.next;
        	}
        	//Ѱ�ұ�list1���list2�Ĳ����
        	if((list1.val<=list2.val)&&(list1.next.val>=list2.val)){
        		tmpNode=new ListNode(list2.val);
        		tmpNode.next=list1.next;
        		list1.next=tmpNode;
        		list1=list1.next;
        		list2=list2.next;
        	}	
        	list1=list1.next;
        }
        //���list2��û������ȫ����Ӧ����while
        if(list2!=null){
        	list1.next=list2;
        }
        return head;       
    }
    /*��Ŀ��    ���������������������������������ϳɺ������
	 *       ��Ȼ������Ҫ�ϳɺ���������㵥����������*/
    public static ListNode RecursiveMerge(ListNode list1,ListNode list2){
    	if(list1==null&&(list2==null))
        	return null;
        else if(list1==null)
        	return list2;
        else if(list2==null)
        	return list1;
    	if(list1.val<list2.val){
    		list1.next=RecursiveMerge(list1.next,list2);
    		return list1;
    	}
    	else{
    		list2.next=RecursiveMerge(list1,list2.next);
    		return list2;
    	}
    }
    
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
    
    /*�����Ŵ�ӡ
	 * �򵥣�������Ԫ�ض��ŵ�һ�������У��������*/
	    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	        ArrayList<Integer> listValue=new ArrayList<Integer>();
	    	if(listNode==null)
	    		return listValue;
	        ArrayList<Integer> reverseListValue=new ArrayList<Integer>();
	        while(listNode.next!=null){
	        	listValue.add(listNode.val);
	        	listNode=listNode.next;
	        }
	        listValue.add(listNode.val);
	        int size=listValue.size();
	        for(int i=size-1;i>=0;i--)
	        	reverseListValue.add(listValue.remove(i));
	        return reverseListValue;
	    }
	    
		
    
}
