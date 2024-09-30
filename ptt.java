package Vidu;

public class ptt {
	int size , count ; 
	int [] a ; 
	public ptt(int size) {
		this.size = size ; 
		this.count = -1;
		this.a = new int [size];
	}
	void push(int data) {
		if (count < a.length) {
			count++;
			a[count] = data;
			System.out.println("Added " + data);
		}else {
			System.exit(0);
		}
	}
	int partition(int x) {
		int mid = (count + 1) / 2;
		int ptt1 = dem(0,mid,x);
		int ptt2 = dem(mid,count + 1, x );
		return ptt1 + ptt2 ;
		
	}
	int dem(int L , int H , int x ) {
		int dem = 0 ;
		for (int i = L ; i < H ; i++) {
			if (a[i] == x) {
				dem +=1;
			}
		}
		return dem;
	}
	void display() {
		for (int i = 0 ; i < count ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ptt p = new ptt(10); // Increased size for demonstration
	        p.push(3);
	        p.push(3);
	        p.push(3);
	        p.push(2);
	        p.push(1);
	        p.push(2);
	        p.push(2);
	        p.push(3);
	        p.push(3);
	        p.push(3);
	        p.display();

	        int result = p.partition(3);
	        System.out.println("Total occurrences of 2: " + result);
	        if (result > (p.count + 1) / 2) {
	            System.out.println("Phan tu troi: 2 xuat hien " + result + " lan.");
	        } else {
	            System.out.println("Khong co phan tu troi.");
	        }

	}

}
