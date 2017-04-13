package Algorithm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 不能用正则表达式*/
public class ReplaceChar {
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
		    

	 public static void main(String args[]){
		 StringBuffer str=new  StringBuffer("abc asd");
		 ReplaceChar replace=new ReplaceChar();
		 System.out.println(replace.replaceSpace(str));
	 }
}
