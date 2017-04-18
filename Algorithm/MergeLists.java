package Algorithm;


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
class ListNode {
	int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
   }
}
public class MergeLists {

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
    public static void main(String args[]){
		
		 ListNode node=new ListNode(5);
		 ListNode nodeSec=new ListNode(2);
		 ListNode nodeHead=node;
		 ListNode nodeSecHead=nodeSec;
		 System.out.print("The first list is: ");
		 for(int i=5;i<8;i++){
			 System.out.print(node.val+" ");
			 node.next=new ListNode(i);
			 node=node.next;
		 }
		 System.out.print(node.val+" ");
		 System.out.println();
		 
		 System.out.print("The second list is: ");
		 for(int i=2;i<8;i++){
			 System.out.print(nodeSec.val+" ");
			 nodeSec.next=new ListNode(i);
			 nodeSec=nodeSec.next;
		 }
		 System.out.print(nodeSec.val+" ");
		 System.out.println();
		 
		 System.out.print("The merged list is: ");
		 //ListNode resultNode=Merge(nodeHead,nodeSecHead);
		 ListNode resultNode=RecursiveMerge(nodeHead,nodeSecHead);
		 while(resultNode.next!=null){
			 System.out.print(resultNode.val+" ");
			 resultNode=resultNode.next;
		 }
		 System.out.print(resultNode.val+" ");
		 System.out.println();
    }
	
}
