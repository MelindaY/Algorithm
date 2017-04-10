package Algorithm;
/*
 * ��ĿҪ������һ���������1-n������Q������n��̨�ף������м�������
 * ���������ڵ�n��̨�ף�����f(n)=f(n-1)+f(n-2)+...+f(1)
 *      ���ڵ�n-1��̨�ף�����f(n-1)=f(n-2)+...+f(1)
 *      ��ˣ�f(n)=2*f(n-1)
 *      ���ߣ�����ÿ��̨�ף����ܿ���ѡ�������߲������������һ��̨�ף�
 *      ��˽��Ϊ2^(n-1)*/
public class CrazyFrogJump {
	static public int JumpFloorII(int target) {
        /* δ�õ����������
         * if(target<=0)
            return 0;
        return 1<<(target-1);//��1����n-1�α�Ϊ2^(n-1)*/    
		int result=1;
		if(target<=0)
            return 0;
		if(target==1)
            return 1;
		while(target>1){
			result*=2;
			target--;
		}
		return result;
		}
	 public static void main(String[] args){
		 
		 System.out.println(JumpFloorII(5));
	 }
}
