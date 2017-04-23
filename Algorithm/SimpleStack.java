package Algorithm;

import java.util.Stack;

public class SimpleStack {
	
	private Stack<Integer> initial=new Stack<Integer>();
	private Stack<Integer> helper=new Stack<Integer>();
	
	/**
	 * 题目要求：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
	 * 思路：        这个题目说实在的，有点怪怪的。
	 *         push：使用两个栈，一个栈存原始数据，一个栈每次进栈前都做比较，要是比它大的话就不压入
	 *         pop:每次pop的时候将原始数据栈的出栈元素和存最小元素的栈比较，如果相等的话两个一起出
	 * @author wzq
	 *
	 */
	public void push(int node) {
		 initial.push(node);
		 if(helper.isEmpty()||helper.peek()>node)
			 helper.push(initial.peek());     
	    }
	    
	    public void pop() {
	    	if(initial.peek()==helper.peek())
	    		helper.pop();
	        initial.pop();
	    }
	    
	    public int top() {
	        return initial.peek();
	    }
	    
	    public int min() {
	    	return helper.peek();
	    }
	    
	    
	/**
	 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
	 *     假设压入栈的所有数字均不相等。
	 *     例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
	 *     但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
	 * 思路：借助第三个stack辅助实现。
	 *      将push组里的元素压入栈中，当该元素等于pop元素时，把辅助stack中元素pop出来
	 *      结束之后判断辅助元素是否为空
	 * @author wzq
	 *
	 */
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
	     if(pushA.length!=popA.length||((pushA.length!=0)&&(popA==null)))
	    	 return false;
	     Stack<Integer> listHelper=new Stack<Integer>();
	     for(int i=0,j=0;i<pushA.length;i++){
	    	 listHelper.push(pushA[i]);
	    	 while(listHelper.peek()==popA[j]&&j<popA.length){
	    		listHelper.pop();
	    		j++;
	            if(listHelper.isEmpty())
	            	break;
	    	 }
	    		
	     }
	     return listHelper.isEmpty();
    }

}
