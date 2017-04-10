package Algorithm;
import java.util.Scanner;
/*
 * 腾讯春招实习生编程题
 * */
public class HexTransfer {
	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		String str = s.nextLine();
		int count=str.length()/16;
		for(int i=0x0;i<count;i++){
            String ss="00000000"+Integer.toHexString(i*16);
            ss=ss.substring(ss.length()-8,ss.length());
			System.out.print(ss);
			System.out.print(" ");
			for(int j=0;j<16;j++){
				int key=(int)str.charAt(j+i);
				System.out.print(Integer.toHexString(key));
				System.out.print(" ");
			}
			System.out.print(" ");
			System.out.print(str.substring(i, i+15));
			System.out.println();
		}
	}
}
