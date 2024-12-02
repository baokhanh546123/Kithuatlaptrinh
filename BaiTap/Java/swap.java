package Vidu;

public class swap {
	static int[] doi (int a , int b) {
		int temp = a ;
		a = b ;
		b = temp ;
		System.out.println("Trong phuong thuc swap  a = " + a + " va  b = " +  b);	
		return new int [] {a,b};
		}
	public static void main(String [] args) {
		int a  = 5 , b = 6  ;
		System.out.println("Truoc khi goi phuong thuc swap  a = " + a + " va  b = " +  b);
		int [] n = swap.doi(a,b);
		a = n[0];
		b = n[1];
		System.out.println("Sau khi goi phuong thuc swap  a = " + a + " va  b = " +  b);
		
	}
}

