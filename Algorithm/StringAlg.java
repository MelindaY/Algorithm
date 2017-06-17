package Algorithm;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @see Algorithm.Tree#BSTInsert(TreeNode, int) Insert
 * <a href="what">key</a>
 * "text"
 * @author wzq
 *
 */
public class StringAlg {
	
	public ArrayList<Character>list;
	private HashMap<Character,Integer> charMap;
	
	public StringAlg(){
		list=new ArrayList<Character>();
		charMap=new HashMap<Character,Integer>();
	}
	public String replaceSpace(StringBuffer str) {
    	/*if(str!=null&&!str.equals(" ")){
            Pattern p=Pattern.compile("\\s");
            Matcher m=p.matcher(str);
            String string=m.replaceAll("%20");
            return string;
        }
        else return str.toString();*/
	 int length,position,spacenum;
        length=str.length();
        position=length-1;
        spacenum=0;
        while(position>=0){
            if(str.charAt(position--)==' '){
                spacenum++; 
            }
        }
        int newlength,newposition;
        position=length-1;
        newlength=length+spacenum*2;
        str.setLength(newlength);
        newposition=newlength-1;
       while(position>=0&&(newposition>position)){
            if(str.charAt(position)==' '){
                str.setCharAt(newposition--, '0');
                str.setCharAt(newposition--, '2');
                str.setCharAt(newposition--, '%');
            }
            else str.setCharAt(newposition--, str.charAt(position));
            position--;
        }
       /*
        * 因为原数组里面有东西，所以从前往后会覆盖*/
        /*for(position=0,newposition=0;position<length;position++){
        if(str.charAt(position)==' '){
            str.setCharAt(newposition++, '0');
            str.setCharAt(newposition++, '2');
            str.setCharAt(newposition++, '%');
        }
        else str.setCharAt(newposition++, str.charAt(position));
        position++;
    }*/
        return str.toString();
        }
	 /**
	  *    Q1:    输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
	  *           则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	  * 输入描述：       输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。*/

	/*
	 * 字典序算法描述：
	 * 1. 对于1,2,3,...,n排序的字符串a1a2...an
	 * 2. 从右向左找到第一个k,a(k)<a(k+1)---> frontIndex
	 * 3. 从k~n找到最小的大于a(k)的索引i----> rearIndex
	 * 4. 交换a(k)和a(i)
	 * 5. 翻转 a(i+1)~a(n)
	 */
	public ArrayList<String> Permutation(String str) {
		 ArrayList<String> FullArrangement=new  ArrayList<String>();
		 if(str.isEmpty())
			 return FullArrangement;
		 str=sortString(str);
		 FullArrangement.add(str);
		 int frontIndex=str.length()-1;
		 int rearIndex=0;
		 do{
			 frontIndex=str.length()-1;
			 //寻找左边的点，因为可能会有重复字符，所以是小于等于
			 while(frontIndex>0&&(str.charAt(frontIndex)<=str.charAt(frontIndex-1)))
				 frontIndex--;
			 if(frontIndex==0)break;
			 frontIndex--;
			 rearIndex=frontIndex;
			 //因为string之前是排序的，所以最右边大于frontIndex的就是rearIndex
			 while(rearIndex<str.length()-1&&str.charAt(frontIndex)<str.charAt(rearIndex+1))
				 rearIndex++;
			 str=swapChar(str, frontIndex,rearIndex);
			 //翻转frontIndex+1到结尾的字符串
			 if(frontIndex+1<str.length()-1)
			     str=inverseSubString(str,frontIndex+1);
			 FullArrangement.add(str);
		 }while(true);
		 
		 return FullArrangement;
	    }
	//将字符串中的字母按照ascii排序
	 public String sortString(String string){
		 char[] chars=string.toCharArray();
		 Arrays.sort(chars);
		 return new String(chars);
	 }
	 //交换字符
	 public String swapChar(String string, int front, int rear){

		 char[] arr=string.toCharArray();
		 arr[front]^=arr[rear];
		 arr[rear]^=arr[front];
		 arr[front]^=arr[rear];
		 return new String(arr);
	 }
	 //翻转从front-end字符串中的每个字符
	 public String inverseSubString(String string,int front){
		 char[] alt=new char[string.length()-front+1];
		 char[] arr=string.toCharArray();
		 for(int i=front;i<string.length();i++){
			 alt[i-front]=string.charAt(i);
		 }
		 int j=0;
		 for(int i=string.length()-1;i>=front;i--){
			 arr[i]=alt[j++];
		 }
		 return new String(arr);
	 }
	 
	 /**在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
	  * 
	  * @param args
	  */
	 public int FirstNotRepeatingChar(String str) {
		 int[] numArray=new int[58];
		 char[] charStr=str.toCharArray();
		 for(char i:charStr)
			 if(i>'A')
			     numArray[i-'A']++; 
		 int priorPos=58;
		 int currentPos=0;
		 for(int i=0;i<58;i++){
			 if(numArray[i]==1){
				 currentPos=getPosition(charStr,(char)(i+'A'));
				 if(currentPos<priorPos)
					 priorPos=currentPos;
			 }
		 }
		 if(priorPos==58)
			 return 0;
		 if(priorPos>26)
			 return priorPos-25;
	     return priorPos+1;
	 }
	 public int getPosition(char[]array, char c){
		 for(int i=0;i<array.length;i++)
			 if(array[i]==c)
				 return i;
		 return 0;
	 }
	 
	 /**
	  * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
	  * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
	  * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
	  * 
	  * 原理：(ArBr)r = ((B)r)r((A)r)r=BA 这样可以使用内置函数reverse
	  * @param args
	  */
	 
	 public String LeftRotateString(String str,int n) {
		 
		 //这样做没什么太大意义
		 /*String result="";
	     if(n<0||n>str.length())
	    	 return result;
	     result=str.substring(n);
	     result+=str.substring(0, n);
	     return result;*/
		 int len = str.length();
		 if(len == 0) return "";
		     n = n % len;
		 str += str;
		 return str.substring(n, len);
		 
	    }
	 /**
	  * 字符串翻转
	  * 例如：student. a am I 到 I am a student
	  * @param str
	  * @return
	  */
	 
	 public String ReverseSentence(String str) {
	        if(str.length()==0||str==" ")
	        	return str;
	        String[] splitWords=str.split(" ");
	        StringBuilder sb=new StringBuilder();
	        for(int i=splitWords.length-1;i>=0;i--){
	        	sb.append(splitWords[i]);
	        	if(i!=0)
	        	     sb.append(" ");
	        }
	        	
	        return sb.toString();
	    }
	 /**
	  * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
	  * 数值为0或者字符串不是一个合法的数值则返回0 
	  * @param str 字符串转换成十进制
	  * @return int型数或0（不可转换）
	  */
	 public int StrToInt(String str) {
	        int result=0;
	        int max=str.length();
	        int limit=0;
	        int midLimit=0;
	        int i=0;
	        char k=' ';
	        int digit;
	        boolean negative=false;
	        if(i<max){
	        	 k=str.charAt(i);
	        	 digit=Character.digit(k, 10);
	        	 if(k=='-'){
	        		 i++;
	        		 limit=Integer.MIN_VALUE;
	        		 negative=true;
	        	 }else{
	        		 if(k=='+'){
	        			 limit=-Integer.MAX_VALUE; 
	        			 i++;
	        		 }
	        		 if(digit>0)
	        			 limit=-Integer.MAX_VALUE; 
	        	 }
	        	 midLimit=limit/10;
	        	 while(i<max){
	        		 digit=Character.digit(str.charAt(i++), 10);
	        		 if(digit<0)//可能会出现小于0且不等于-1的值吗
	        			 return 0;
	        		 if(result<midLimit)
	        			 return 0;
	        		 result*=10;
	        		 //为什么加这个
	        		 if (result < limit + digit)
	        			 return 0;
	        		 result-=digit;
	        	 }
	        	 if(negative){
	        		 if(i>1)
	        		     return result;
	        		 else
	        			 return 0;
	        	 }	 
	        	 else
	        		 return -result;
	        }
	        else
	        	return 0;
	        
	    }
	 
	 /**
	  * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
	  * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
	  * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
	  * @param str
	  * @param pattern
	  * @return
	  */
	 public boolean match(char[] str, char[] pattern)
	 {
	        if((str==null&&pattern==null))
	        	return true;
	        if((str!=null&&pattern==null))
	        	return false;
	        return matchString(str,0, pattern,0);
	        
	 }
	
	private boolean matchString(char[] str,int strSt, char[] pattern,int patSt){
		 if((strSt==str.length)&&(patSt==pattern.length))
			 return true;
		if(strSt != str.length && patSt== pattern.length)
			 return false;
		 if(patSt+1<pattern.length){
			 if((str.length!=strSt)&&(pattern[patSt+1]!='*')){//第二位不是‘*’
				 if((pattern[patSt]!=str[strSt])&&(pattern[patSt]!='.'))
					 return false;
				 return matchString(str,strSt+1, pattern,patSt+1);
			 }
			 else{//第二位是'*'
				 if((str.length!=strSt&&pattern[patSt]=='.')||(str.length!=strSt&&pattern[patSt]==str[strSt]))
					 return matchString(str,strSt, pattern,patSt+2)||//匹配0个字符
							 matchString(str,strSt+1, pattern,patSt)||//匹配1+字符
							 matchString(str,strSt+1, pattern,patSt+2);//匹配1个字符
				 else
					 return matchString(str,strSt, pattern,patSt+2);
			 }
		 }
		 else{
			 if((str.length!=strSt)&&(pattern[patSt]!=str[strSt])&&(pattern[patSt]!='.'))
				 return false;
			 return matchString(str,strSt+1, pattern,patSt+1);
		 }
	 }
	 
/*
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
	public boolean isNumeric(char[] str) {
        String s=String.valueOf(str);
        String regex="[\\+-]?[0-9]*(\\.[0-9]*)?([e|E][\\+-]?[0-9]+)?";
        return s.matches(regex);
    }
	
	/**
	 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
	 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 
	 * @param ch
	 */
	//Insert one char from stringstream
	public void Insert(char ch)
    {
		list.add(ch);
		if(charMap.containsKey(ch)){
			charMap.replace(ch, charMap.get(ch)+1);
		}
		else
            charMap.put(ch, 1);
    }
	  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	for(char c:list)
    		if(charMap.get(c)==1)
    			return c;
    	return '#';
    }
	    
	 public static void print(Object O){
			System.out.println(O);
		}
	 
	 public void getMap(){
		 print(this.charMap);
	 }
		
	 public static void main(String args[]){
	 /*StringBuffer str=new  StringBuffer("abc asd");
	 StringAlg stringAlg=new StringAlg();
	 System.out.println(stringAlg.replaceSpace(str));
	 ArrayList<String> arr=new ArrayList<String>();
	 arr=stringAlg.Permutation("kasygdfua");*/
		 
	 //ArrayList<String> arr=new ArrayList<String>();
	 /*int[] t={1,2,3,4,5};
	 int length=0;*/
	 StringAlg stringAlg=new StringAlg();
	 int i=0;
	 char[] a="google".toCharArray();
	 for(char s:a){
		 stringAlg.Insert(s); 
	 }
	 stringAlg.getMap();
	 print(stringAlg.FirstAppearingOnce());
 }
}
