package Vidu;

public class UocNhoNhat {
	static int a , b ; 
	static int find(int a , int b) {
		int tempA = a ;
		int tempB = b ;
		while (tempB != 0) {
			int temp = tempA % tempB ;
			tempA = tempB;
			tempB = temp;
		}
		return tempA ;
	}
	static int findBCNN() {
		int ucln = find(a,b);
		return Math.abs(a*b) / ucln;
	}
	static void display() {
        int bcnn = findBCNN(); 
        System.out.println("BCNN của " + a + " và " + b + " là: " + bcnn);
    }
	
	public static void main(String[] args) {
 
		 UocNhoNhat.a = 108;
		 UocNhoNhat.b = 17;
		 UocNhoNhat.display();
    }
}
