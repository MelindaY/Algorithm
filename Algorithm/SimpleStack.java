package Algorithm;

import java.util.Stack;

public class SimpleStack {
	
	private Stack<Integer> initial=new Stack<Integer>();
	private Stack<Integer> helper=new Stack<Integer>();
	
	/**
	 * ��ĿҪ�󣺶���ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
	 * ˼·��        �����Ŀ˵ʵ�ڵģ��е�ֵֹġ�
	 *         push��ʹ������ջ��һ��ջ��ԭʼ���ݣ�һ��ջÿ�ν�ջǰ�����Ƚϣ�Ҫ�Ǳ�����Ļ��Ͳ�ѹ��
	 *         pop:ÿ��pop��ʱ��ԭʼ����ջ�ĳ�ջԪ�غʹ���СԪ�ص�ջ�Ƚϣ������ȵĻ�����һ���
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
	 * ��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
	 *     ����ѹ��ջ���������־�����ȡ�
	 *     ��������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
	 *     ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
	 * ˼·������������stack����ʵ�֡�
	 *      ��push�����Ԫ��ѹ��ջ�У�����Ԫ�ص���popԪ��ʱ���Ѹ���stack��Ԫ��pop����
	 *      ����֮���жϸ���Ԫ���Ƿ�Ϊ��
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
