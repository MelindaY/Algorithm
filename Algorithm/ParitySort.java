package Algorithm;
/*
 * ��Ŀ��     ���룺һ������ �����ǰ����������������ż��������������֮��˳�򲻱�
 * ˼·��     ������һ���������洢���������Σ�һ��Ϊ������һ��Ϊż��
 * ���⣺      �����Ŀ�����ѣ������Ҷ������ֵ���ݺ����ô����е���ⲻ͸��
 * *************************************************************
 * Others��û�п����ر�õĽ����������Ȼ���ǻ�����ȥ��
 * */
public class ParitySort {
	public static void reOrderArray(int [] array) {
		if(array==null)
			throw new RuntimeException("empty array!");
        int[] t=new int[array.length];
        // int[] t=a; �����Ӿͻ��tָ��a��Ȼ����˵���滹������tһ�仯��aҲ�仯
        int position=0;
        for(int i=0;i<array.length;i++)
        	if(array[i]%2!=0){
        	    t[position++]=array[i];    
        	}
        for(int i=0;i<array.length;i++)
        	if(array[i]%2==0)
        	{
        		t[position++]=array[i];
        		/*if(position!=array.length)
        			position++;*/
        	}
        //a=t; ��ʱ��aָ��t�����������βΰ��������ȳ��������aҲ��ָ��t������ȥָ��ԭ�ȵ�λ����
        for(int i=0;i<array.length;i++)
        	array[i]=t[i];

    }
	 public static void main(String args[]){
		
		 int[] array={0,2,-3,1,99,4,-5};
		 array[222]=0;
		 reOrderArray(array);
		for(int i:array)
		 System.out.println(i);
		
	 }

}
