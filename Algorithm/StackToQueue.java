package Algorithm;

import java.util.Stack;
/*��ĿҪ�� ������ջʵ�ֶ���
 * ˼·��      ÿ��push��push��Stack1��
 *        Pop��ʱ�����ж�Stack2�ǲ��ǿյģ�������Ǿ�Pop�����
 *                 ���ϴ�Stack1 pop������ûŪ�꣩
 *                 ����ǿյĻ���ȫ����Stack1 pop������push��ȥ���е���������*/
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
