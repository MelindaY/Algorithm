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
	 * 题目：    输入两个单调递增的链表，输出两个链表合成后的链表，
	 *       当然我们需要合成后的链表满足单调不减规则。
	 *       
	 * 思考：    说实在的，这段代码写的真是憋屈，链表的迷人（变态）之处就在于很难保全头引用和插入点
	 *       切记：ListNode node=list1;
	 *           如果将node.next=list2之后，list1.next也会等于list2！
	 *           但是可以主观改node的引用，比如node=list2（只要不是final的就行）
	 *       因为我不喜欢递归！NOT AT ALL！
	 *       所以呢，我这个非递归的方式，怎么说呢，我觉得写得一般
	 *       实在是不想再看别人的非递归版本了吐血
	 ***********************************************************************
	 *       递归方法：详见
	 *       讲真，这个题用递归就1分钟。但是我貌似不习惯递归的思维
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
        	//将所有小于list1的数字全部插到list之前
        	while((list1.val>list2.val)&&(list2.next!=null)){
        		tmpNode=new ListNode(list2.val);
        		tmpNode.val=list2.val;
        		tmpNode.next=list1;
        		next=head;
        		if(head.val>tmpNode.val)//如果前面未插入过一个list2元素
        			head=tmpNode;
        		else{
        			next=head.next;
        			pre=head;
        			//寻找插入点，并记录前后元素。
        			while(next.val<list2.val){
        				pre=pre.next;
            			next=next.next;
            		}
        			pre.next=tmpNode;
        			tmpNode.next=next;
        		}
        		
            	list2=list2.next;
        	}
        	//寻找比list1大的list2的插入点
        	if((list1.val<=list2.val)&&(list1.next.val>=list2.val)){
        		tmpNode=new ListNode(list2.val);
        		tmpNode.next=list1.next;
        		list1.next=tmpNode;
        		list1=list1.next;
        		list2=list2.next;
        	}	
        	list1=list1.next;
        }
        //如果list2还没遍历完全，不应该用while
        if(list2!=null){
        	list1.next=list2;
        }
        return head;       
    }
    /*题目：    输入两个单调递增的链表，输出两个链表合成后的链表，
	 *       当然我们需要合成后的链表满足单调不减规则。*/
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
    
    /*链表反着打印
	 * 简单，把所有元素都放到一个数组中，反着输出*/
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
