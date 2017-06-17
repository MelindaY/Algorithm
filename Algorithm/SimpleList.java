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
    
    /*题目要求： 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     *        另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     *       （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）*/
    public RandomListNode Clone(RandomListNode pHead)
    {
    	RandomListNode cloneHead=new RandomListNode(pHead.label);//定义头结点
    	cloneHead.next=null;
    	cloneHead.random=null;
    	RandomListNode cloneNode=pHead.next;//指针走向
    	RandomListNode doubleCloneHead=cloneHead;
    	if(pHead==null)
    		return null;
    	//处理next节点
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
    /*输入两个链表，找出它们的第一个公共结点。*/
    /*
     * 关键点： 因为最终两个链表会构成一个“Y”型（单链表只有一个next，因此只要有一个相同节点后面便都是相同的）
     *  思路：  引入辅助栈，找到最后一个相同的元素
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
    /*思路：先遍历list，计算长度
     *     比较长度，较长的list从和第二个list长度相同的地方开始一起遍历
     *     
     *原因：  因为最终两个链表会构成一个“Y”型（单链表只有一个next，因此只要有一个相同节点后面便都是相同的）*/
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    	if(pHead1==null||pHead2==null)
    		return null;
    	 ListNode pHeadHead1=pHead1;
    	 ListNode pHeadHead2=pHead2;
    	 int count1=0;
    	 int count2=0;
    	 //先遍历list，计算长度
    	 while(pHead1!=null){
    		 count1++;
    		 pHead1=pHead1.next;
    	 }
    	 
    	 while(pHead2!=null){
    		 count2++;
    		 pHead2=pHead2.next;
    	 }
    	 //比较长度，较长的list从和第二个list长度相同的地方开始一起遍历
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
     * 一个链表中包含环，请找出该链表的环的入口结点
     * 1.两个指针，p1,p2,p1一个每次走一步，p2一个走两步.当p1=p2。
     *   当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,
     *   设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数
     * 2.p2=pHead 如果p1直接等于p2,那么就是p1,即pHead
     * 3.每次都走一步 再碰上即头
     */
   public ListNode EntryNodeOfLoop(ListNode pHead)
    {
	   //这样是不行的，因为没有尾（没有哪个node.next==null,就会陷入死循环）啊！
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
    * 在一个排序的链表中，存在重复的结点，
    * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
			   //两者顺序也要变化
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
