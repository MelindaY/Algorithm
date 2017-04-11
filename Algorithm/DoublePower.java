package Algorithm;

public class DoublePower {
	public static double exponetDouble(double base,int exponent){
		double result=1;
		for(int i=0;i<Math.abs(exponent);i++)
			result*=base;
		if(exponent<0)
			return 1/result;
		return result;
	}
	public static void main(String[] args){

		System.out.println(exponetDouble(2,-3));
	}

}