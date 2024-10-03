package Vidu;

public class SelectionSort {
	int [] a ; 
	int size , count  ; 
	public SelectionSort(int size ) {
		this.a = new int [size];
		this.size = size ;
		this.count = -1 ;
	}
	
	public void push(int i){
        if (count < size - 1){  // Check if there's room to add the element
            count++;
            a[count] = i;
            System.out.println("Added: " + i);
        }
        else{
            System.out.println("FULL");
        }
    }
	public void sort() {
		for (int i = 0 ; i < count ; i++) {
			int min = i ; 
			for (int j = i + 1 ; j < count ; j++) {
				if (a[j] < a[min]) {
					min = j ;
				}
			if (min != i ) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
				}
			}
		}
	}
	 public void displayArray() {
	        for (int i = 0; i <= count; i++) {
	            System.out.print(a[i] + " ");
	        }
	        System.out.println();
	    }
	 public static void main(String[] args) {
	        SelectionSort m = new SelectionSort(3);  // Create an instance with size 3
	        m.push(6);  // Add elements
	        m.push(3);
	        m.push(9);
	        m.sort();
	        m.displayArray();// This will print "FULL" because the array is full
	    }

}
