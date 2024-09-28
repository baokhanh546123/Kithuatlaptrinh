package Vidu;

public class dem {
	int size , count ; 
	int [] a ; 
	public dem(int size) {
		this.size = size ; 
		this.count = -1 ;
		this.a = new int [size];
	}
	public void push(int data) {
		if (count >= a.length) {
			System.exit(0);
		}else {
			count++;
			a[count] = data ; 
			System.out.println("Added to " + data);
		}
	}
	public int count(int [] a , int i , int counts , int x ) {
		if (i >= a.length - 1) {
			return counts;
		}else {
			if (a[i] == x ) {
				counts++;
			}
		}
		return count(a,i+1,counts,x);
	}
	 public static void main(String[] args) {
	        dem d = new dem(5);
	        d.push(4);
	        d.push(5);
	        d.push(4);
	        d.push(4);
	        d.push(5);
	        
	        int x = 4;  // The number to count
	        int result = d.count(d.a, 0, 0, x);  // Count occurrences of '4'
	        System.out.println("Number " + x + " appears " + result + " times.");
		    int x1 = 5;
		    int result1 = d.count(d.a, 0, 0, x1);  // Count occurrences of '4'
	        System.out.println("Number " + x1 + " appears " + result1 + " times.");
		    
	        
	 }
	 
	 
}

