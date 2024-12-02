package Vidu;

public class tangdan {
	int size , count ; 
	int [] a; 
	public tangdan(int size) {
		this.size = size ; 
		this.count = -1;
		this.a = new int [size];
	}
	
	public void push(int data) {
		if (count < size - 1) {
			count++;
			a[count] = data;
			System.out.println("Added: " + data);
		}else {
			System.out.println("FULL");
		}
	}
	public int check(int index , int dstn) {
		if (index >= count) {
			return dstn;
		}
		if (a[index] < a[index + 1]) {
			dstn++;
		}
		return check(index + 1  ,dstn);
	}
	public void display() {
		for(int i = 0 ; i <= count ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	 public static void main(String[] args) {
	       	tangdan m = new tangdan(5); // Initialized with a size of 5
	        m.push(3);
	        m.push(12);
	        m.push(13);
	        m.push(15);
	        m.display();
	        int result = m.check(0, 0);
	        System.out.println("Number of increasing pairs: " + result);
	 }







}
