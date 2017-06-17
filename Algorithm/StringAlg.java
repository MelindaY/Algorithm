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
        * ��Ϊԭ���������ж��������Դ�ǰ����Ḳ��*/
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
	  *    Q1:    ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,
	  *           ���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
	  * ����������       ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��*/

	/*
	 * �ֵ����㷨������
	 * 1. ����1,2,3,...,n������ַ���a1a2...an
	 * 2. ���������ҵ���һ��k,a(k)<a(k+1)---> frontIndex
	 * 3. ��k~n�ҵ���С�Ĵ���a(k)������i----> rearIndex
	 * 4. ����a(k)��a(i)
	 * 5. ��ת a(i+1)~a(n)
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
			 //Ѱ����ߵĵ㣬��Ϊ���ܻ����ظ��ַ���������С�ڵ���
			 while(frontIndex>0&&(str.charAt(frontIndex)<=str.charAt(frontIndex-1)))
				 frontIndex--;
			 if(frontIndex==0)break;
			 frontIndex--;
			 rearIndex=frontIndex;
			 //��Ϊstring֮ǰ������ģ��������ұߴ���frontIndex�ľ���rearIndex
			 while(rearIndex<str.length()-1&&str.charAt(frontIndex)<str.charAt(rearIndex+1))
				 rearIndex++;
			 str=swapChar(str, frontIndex,rearIndex);
			 //��תfrontIndex+1����β���ַ���
			 if(frontIndex+1<str.length()-1)
			     str=inverseSubString(str,frontIndex+1);
			 FullArrangement.add(str);
		 }while(true);
		 
		 return FullArrangement;
	    }
	//���ַ����е���ĸ����ascii����
	 public String sortString(String string){
		 char[] chars=string.toCharArray();
		 Arrays.sort(chars);
		 return new String(chars);
	 }
	 //�����ַ�
	 public String swapChar(String string, int front, int rear){

		 char[] arr=string.toCharArray();
		 arr[front]^=arr[rear];
		 arr[rear]^=arr[front];
		 arr[front]^=arr[rear];
		 return new String(arr);
	 }
	 //��ת��front-end�ַ����е�ÿ���ַ�
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
	 
	 /**��һ���ַ���(1<=�ַ�������<=10000��ȫ���ɴ�д��ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
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
	  * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
	  * ����һ���������ַ�����S���������ѭ������Kλ������������
	  * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
	  * 
	  * ԭ��(ArBr)r = ((B)r)r((A)r)r=BA ��������ʹ�����ú���reverse
	  * @param args
	  */
	 
	 public String LeftRotateString(String str,int n) {
		 
		 //������ûʲô̫������
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
	  * �ַ�����ת
	  * ���磺student. a am I �� I am a student
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
	  * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
	  * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0 
	  * @param str �ַ���ת����ʮ����
	  * @return int������0������ת����
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
	        		 if(digit<0)//���ܻ����С��0�Ҳ�����-1��ֵ��
	        			 return 0;
	        		 if(result<midLimit)
	        			 return 0;
	        		 result*=10;
	        		 //Ϊʲô�����
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
	  * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
	  * ��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
	  * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
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
			 if((str.length!=strSt)&&(pattern[patSt+1]!='*')){//�ڶ�λ���ǡ�*��
				 if((pattern[patSt]!=str[strSt])&&(pattern[patSt]!='.'))
					 return false;
				 return matchString(str,strSt+1, pattern,patSt+1);
			 }
			 else{//�ڶ�λ��'*'
				 if((str.length!=strSt&&pattern[patSt]=='.')||(str.length!=strSt&&pattern[patSt]==str[strSt]))
					 return matchString(str,strSt, pattern,patSt+2)||//ƥ��0���ַ�
							 matchString(str,strSt+1, pattern,patSt)||//ƥ��1+�ַ�
							 matchString(str,strSt+1, pattern,patSt+2);//ƥ��1���ַ�
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
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� 
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */
	public boolean isNumeric(char[] str) {
        String s=String.valueOf(str);
        String regex="[\\+-]?[0-9]*(\\.[0-9]*)?([e|E][\\+-]?[0-9]+)?";
        return s.matches(regex);
    }
	
	/**
	 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
	 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"�� 
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
