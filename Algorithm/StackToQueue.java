package Algorithm;

import java.util.Stack;
/*题目要求： 用两个栈实现队列
 * 思路：      每次push都push到Stack1中
 *        Pop的时候，先判断Stack2是不是空的，如果不是就Pop这个的
 *                 （上次Stack1 pop出来的没弄完）
 *                 如果是空的话，全部将Stack1 pop出来，push进去（有点像汉罗塔）*/
public class StackToQueue {
	 Stack<Integer> stack1 = new Stack<Integer>();
	 Stack<Integer> stack2 = new Stack<Integer>();
	 public void push(int node) {
	        stack1.push(node);
	    }
	    
	    public int pop() {
	    	if(!stack2.isEmpty())
	    		return stack2.pop();
	    	else{
		    	while(!stack1.isEmpty())
			        stack2.push(stack1.pop());
		            return stack2.pop();
	    	}
	    }
	    public static void main(String args[]){
	    	
	    	StackToQueue stackQueue=new StackToQueue();
	    	stackQueue.push(1);
	    	stackQueue.push(2);
	    	stackQueue.push(3);
	    	System.out.println(stackQueue.pop());
	    	System.out.println(stackQueue.pop());
	    	stackQueue.push(4);
	    	System.out.println(stackQueue.pop());
	    	stackQueue.push(5);
	    	System.out.println(stackQueue.pop());
	    	System.out.println(stackQueue.pop());
	    	
	    }


}
