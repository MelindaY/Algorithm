package Algorithm;

import java.util.Stack;
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
public class OutStackJudge {
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
	public static void main(String[] args){
		int [] pushA={1,2,3,4,5};
		int [] popA={4,5,3,2,1};
		System.out.println(IsPopOrder(pushA,popA));
	}

}
