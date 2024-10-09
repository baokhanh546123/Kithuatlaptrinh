public class InsertSort
{
	int count, size ;
	int [] a ;
	public InsertSort(int size) {
		this.size = size ;
		this.count = -1;
		this.a = new int [size];
	}

	void push(int data) {
		if (count <=  a.length  ) {
			count++;
			a[count] = data;
		} else {
			System.exit(0);
		}
	}
	void insertsort(){
	    for(int i = 0 ; i <= count ; i++){
	        int key = a[i];
	        int j = i - 1 ;
	        while(j >= 0 && a[j] > key ){
	            a[j+1] = a[j];
	            j -=1;
	        }
	        a[j+1]=key;
	    }
	}
	
	void display() {
		for(int i = 0 ; i <= count ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	public static void main (String[] args) {
		InsertSort m = new InsertSort(4);
		m.push(4);
		m.push(5);
		m.push(3);
		m.push(1);
		m.display();
		m.insertsort();
		m.display();
	}
}
