package Algorithm;

import java.util.Stack;
/**
 * ��ĿҪ�󣺶���ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * ˼·��        �����Ŀ˵ʵ�ڵģ��е�ֵֹġ�
 *         push��ʹ������ջ��һ��ջ��ԭʼ���ݣ�һ��ջÿ�ν�ջǰ�����Ƚϣ�Ҫ�Ǳ�����Ļ��Ͳ�ѹ��
 *         pop:ÿ��pop��ʱ��ԭʼ����ջ�ĳ�ջԪ�غʹ���СԪ�ص�ջ�Ƚϣ������ȵĻ�����һ���
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
