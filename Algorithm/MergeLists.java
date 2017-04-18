package Algorithm;


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
