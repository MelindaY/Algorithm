package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

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
    public ListNode Merge(ListNode list1,ListNode list2) {
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
    public ListNode RecursiveMerge(ListNode list1,ListNode list2){
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
    public ListNode FindKthToTail(ListNode head,int k) {
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
    public  ListNode ReverseList(ListNode head) {
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
    
    /*��ĿҪ�� ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬
     *        ��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
     *       ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�*/
    public RandomListNode Clone(RandomListNode pHead)
    {
    	RandomListNode cloneHead=new RandomListNode(pHead.label);//����ͷ���
    	cloneHead.next=null;
    	cloneHead.random=null;
    	RandomListNode cloneNode=pHead.next;//ָ������
    	RandomListNode doubleCloneHead=cloneHead;
    	if(pHead==null)
    		return null;
    	//����next�ڵ�
    	while(cloneNode!=null){
    		RandomListNode newNode=new RandomListNode(cloneNode.label);
    		newNode.next=null;
    		newNode.random=null;
    		doubleCloneHead.next=newNode;
    		doubleCloneHead=doubleCloneHead.next;
    		cloneNode=cloneNode.next;
    	}
       /*cloneNode=pHead;
       doubleCloneHead=cloneHead;
       HashMap<Integer,RandomListNode>randomMap=new  HashMap<Integer,RandomListNode>();
       while(cloneNode!=null){
    	   randomMap.put(cloneNode.label, cloneNode.random);
       }
      while(doubleCloneHead!=null){
    	  doubleCloneHead.random=randomMap.get(doubleCloneHead.label);
    	  doubleCloneHead=doubleCloneHead.next;
      }*/
    	return cloneHead;
        
    }
    /*�������������ҳ����ǵĵ�һ��������㡣*/
    /*
     * �ؼ��㣺 ��Ϊ������������ṹ��һ����Y���ͣ�������ֻ��һ��next�����ֻҪ��һ����ͬ�ڵ����㶼����ͬ�ģ�
     *  ˼·��  ���븨��ջ���ҵ����һ����ͬ��Ԫ��
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if(pHead1==null||pHead2==null)
    		return null;
    	 Stack<ListNode> stackHead1=new Stack<ListNode>();
    	 Stack<ListNode> stackHead2=new Stack<ListNode>();
    	 ListNode pHead1Node=null;
    	 while(pHead1!=null){
    		 stackHead1.push(pHead1);
    		 pHead1=pHead1.next;
    	 }
    	 while(pHead2!=null){
    		 stackHead2.push(pHead2);
    		 pHead2=pHead2.next;
    	 }
    	 while(!stackHead1.isEmpty()&&!stackHead2.isEmpty()){
    		 if(stackHead1.peek()==stackHead2.peek()){
    			 pHead1Node=stackHead1.pop();
    			 stackHead2.pop();
    		 }
    		 if(!stackHead1.isEmpty()&&!stackHead2.isEmpty())
    		     if(stackHead1.peek()!=stackHead2.peek())
    			     break;
    	 }
    	 return pHead1Node;	 
    }
    /*˼·���ȱ���list�����㳤��
     *     �Ƚϳ��ȣ��ϳ���list�Ӻ͵ڶ���list������ͬ�ĵط���ʼһ�����
     *     
     *ԭ��  ��Ϊ������������ṹ��һ����Y���ͣ�������ֻ��һ��next�����ֻҪ��һ����ͬ�ڵ����㶼����ͬ�ģ�*/
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    	if(pHead1==null||pHead2==null)
    		return null;
    	 ListNode pHeadHead1=pHead1;
    	 ListNode pHeadHead2=pHead2;
    	 int count1=0;
    	 int count2=0;
    	 //�ȱ���list�����㳤��
    	 while(pHead1!=null){
    		 count1++;
    		 pHead1=pHead1.next;
    	 }
    	 
    	 while(pHead2!=null){
    		 count2++;
    		 pHead2=pHead2.next;
    	 }
    	 //�Ƚϳ��ȣ��ϳ���list�Ӻ͵ڶ���list������ͬ�ĵط���ʼһ�����
    	 if(count2>count1){
    		 for(int i=0;i<count2-count1;i++)
    			 pHeadHead2=pHeadHead2.next;
    	 }
    	 else
    	 {
    		 for(int i=0;i<count1-count2;i++)
    			 pHeadHead1=pHeadHead1.next;
    	 }
    	 
    	 while(pHeadHead1!=null&&pHeadHead2!=null){
    		 if(pHeadHead1==pHeadHead2)
    			 break;
    		 pHeadHead1=pHeadHead1.next;
    		 pHeadHead2=pHeadHead2.next;
    	 }
    	 
    	 return pHeadHead1;
    	 
    }
	
    /*
     * һ�������а����������ҳ�������Ļ�����ڽ��
     * 1.����ָ�룬p1,p2,p1һ��ÿ����һ����p2һ��������.��p1=p2��
     *   ��p1==p2ʱ��p2�������ڵ���Ϊ2x,p1�������ڵ���Ϊx,
     *   �軷����n���ڵ�,p2��p1����һȦ��2x=n+x; n=x;���Կ���p1ʵ������һ�����Ĳ���
     * 2.p2=pHead ���p1ֱ�ӵ���p2,��ô����p1,��pHead
     * 3.ÿ�ζ���һ�� �����ϼ�ͷ
     */
   public ListNode EntryNodeOfLoop(ListNode pHead)
    {
	   //�����ǲ��еģ���Ϊû��β��û���ĸ�node.next==null,�ͻ�������ѭ��������
        /*if(pHead==null)
        	return null;
        ListNode entry=null;
        while(pHead.next!=null){
        	entry=pHead.next;
        	entry=entry.next;
        }
        return entry.next;*/
	   if(pHead==null)
           return null;
	   ListNode list1=pHead;
	   ListNode list2=pHead;
	   do{
		   if(list1.next==null||list2.next.next==null)
			   return null;
		   list1=list1.next;
		   list2=list2.next.next;
		   
	   }while(list1!=list2);
	   list2=pHead;
	   if(list2==list1)
		   return list1;
	   do{
		   list1=list1.next;
		   list2=list2.next;
	   }while(list1!=list2);
	   return list1.next;
    }
   /**
    * ��һ������������У������ظ��Ľ�㣬
    * ��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
    * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
    * @param pHead
    * @return
    */
   public ListNode deleteDuplication(ListNode pHead)
   {
	   if(pHead==null)
		   return null;
	   ListNode Head=new ListNode((int)Double.NEGATIVE_INFINITY);
	   Head.next=pHead;
	   ListNode forwardHead=Head.next;
	   ListNode backHead=Head;
	   while(forwardHead!=null){
		   while((forwardHead.next!=null)&&(forwardHead.val==forwardHead.next.val)){
			   forwardHead=forwardHead.next;
		   }
		   if(backHead.next!=forwardHead){
			   //����˳��ҲҪ�仯
			   forwardHead=forwardHead.next; 
			   backHead.next=forwardHead;
			     
		   }
		   else{
			   backHead=forwardHead;
			   forwardHead=forwardHead.next;   
		   }
	   }
	   //backHead.next=null;
	   return Head.next;
   }
    
    public static void main(String[] args){
    	ListNode list0=new ListNode(1);
    	ListNode list1=new ListNode(2);
    	ListNode list2=new ListNode(3);
    	ListNode list3=new ListNode(5);
    	ListNode list4=new ListNode(5);
    	list0.next=list1;
    	list1.next=list2;
    	list2.next=list3;
    	list3.next=list4;
    	list4.next=null;
    	SimpleList sl=new SimpleList();
    	ListNode list=sl.deleteDuplication(list0);
    	while(list!=null){
    		System.out.println(list.val);
    		list=list.next;
    	}
    	     
    }
		
    
}
