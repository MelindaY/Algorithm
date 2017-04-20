package Algorithm;

import java.util.Stack;
/**
 * 题目要求：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：        这个题目说实在的，有点怪怪的。
 *         push：使用两个栈，一个栈存原始数据，一个栈每次进栈前都做比较，要是比它大的话就不压入
 *         pop:每次pop的时候将原始数据栈的出栈元素和存最小元素的栈比较，如果相等的话两个一起出
 * @author wzq
 *
 */
public class StackRealization {
	private Stack<Integer> initial=new Stack<Integer>();
	private Stack<Integer> helper=new Stack<Integer>();
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
	    public static void main(String[] args){
	    	StackRealization stackTest=new StackRealization();
	    	stackTest.push(5);
	    	stackTest.push(6);
	    	stackTest.push(2);
	    	stackTest.push(9);
	    	System.out.println(stackTest.min());
	    }
}
