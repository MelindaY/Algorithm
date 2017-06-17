package Algorithm;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AssertTest {
	public int add(int a){
		//myLogger.entering("Algorithm.AssertTest", "add");
		int t[]=new int[2];
		t[a]=1;
		//myLogger.exiting("Algorithm.AssertTest", "add");
		return a+=7;
	}
	public static void main(String[]args){
		//AssertTest at=new AssertTest();
		//System.out.println(at.add(-8));
		//Logger.getGlobal().info("Log");
		//myLogger.setLevel(Level.FINE);
		//Logger.getGlobal().setLevel(Level.OFF);
		
		//Logger.getLogger("AssertTest");
	}
	
	//private static final Logger myLogger=Logger.getLogger("Algorithm");
}
