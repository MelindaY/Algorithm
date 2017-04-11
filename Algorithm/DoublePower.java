package Algorithm;
/*
 * ��ĿҪ������һ��double�������ֺ�ָ������������
 * ˼�����̣���Ҫ�����Ѿ�������ָ����Ҫ��͹��򣬹�˭��Ц��
 *         Step1��������^���ţ������������������֧��double��
 *         Step2��Ȼ���Ҿ͵����˰�����֪���϶��кð취�������Ҳ��ᰡ����
 *         Step3���Ҹ������˻���ָ���Ǹ�������£��������ϵ�
 *         Step4���ܶ�����Ĳ�������û���뵽��0^0�͸��������塣����0���κ�����0�η���Ϊ1
 *         Step5: �����˵Ĵ����޸��Լ��ģ����͵ĸ��Ӷ�
 *                ��Ҫ˼�룺���x=y+z,��ôa^x=a^(y+z)=a^y*a^x
 *                       ����x=5=101,a^5=a^100*a^1(ͨ�������λʵ��)
 * ��᣺         ��д����ǰ��������п��ܵ�����������߽�㣩����Ҫ����������ģ��κ��������ݺ���
 *         ����ʵ����˵���Լ�Ƿȱ��ɢ��˼ά�����Ĳ���
 * */
public class DoublePower {
	public static double exponetDouble(double base,int n){
		
		/*v1.0 by Melinda. full of mistakes
		double result=1;
		for(int i=0;i<Math.abs(exponent);i++)
			result*=base;
		if(exponent<0)
			return 1/result;
		return result;*/
		//avoid any possible mistakes and exceptions
		int exponent=0;
		double res=1;
		double iter=base;
		if(base==0&&n==0)
			throw new RuntimeException("there is no answer");;
		if(base==0&&n<=0)
			throw new ArithmeticException("divided by 0");
		if(n<0)
			exponent=-n;
		else if(n>0)
			exponent=n;
		else return 1;
		while(exponent!=0){
			if((exponent&1)==1)
				res*=iter;
			iter*=iter;
			exponent>>=1;
		}
		return n>0?res:1/res;
					
	}
	public static void main(String[] args){

		System.out.println(exponetDouble(0,-1));

	}

}