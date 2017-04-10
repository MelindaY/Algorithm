package Algorithm;
import java.util.*;
public class ReversePrintList {
	class ListNode {
		int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
       }
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
	    public static void main(String[] args){
	    	ReversePrintList printList=new ReversePrintList();
	    	ReversePrintList.ListNode listNode=printList.new ListNode(5);
	    	ReversePrintList.ListNode listNode2=printList.new ListNode(3);
	    	ReversePrintList.ListNode listNode3=printList.new ListNode(4);
	    	ReversePrintList.ListNode listNode4=null;
	    	listNode.next=listNode2;
	    	listNode2.next=listNode3;
	    	 ArrayList<Integer> listValue=new ArrayList<Integer>();
	    	 listValue=printList.printListFromTailToHead(listNode4);
	    	 for(Integer i:listValue)
	    		 System.out.println(i);
	    		 
	    }
	
}
