package Algorithm;

import java.util.Stack;
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
