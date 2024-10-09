public class QuickSort
{
	int count, size ;
	int [] arr ;
	public QuickSort(int size) {
		this.size = size ;
		this.count = -1;
		this.arr = new int [size];
	}

	void push(int data) {
		if (count <  arr.length - 1 ) {
			count++;
			arr[count] = data;
		} else {
			System.exit(0);
		}
	}
	int partition(int low, int high) {
		int key = arr[high]; //lay cuoi
		int i = low - 1 ;
		for (int j = low; j < high ; j++) {
			if (arr[j] < key) {
				i++;
				swap(i,j);
			}
		}
		swap(i+1,high);
		return i+1;
	}
	void swap(int i, int j) {
		int temp = arr[i] ;
		arr[i] = arr[j];
		arr[j] = temp;
	}
	void quicksort(int low, int high) {
		if (low < high) {
			int pi = partition(low,high);
			quicksort(low,pi-1);
			quicksort(pi+1,high);
		}
	}
	void display() {
		for(int i = 0 ; i <= count ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main (String[] args) {
		QuickSort m = new QuickSort(4);
		m.push(4);
		m.push(5);
		m.push(3);
		m.push(1);
		m.display();
		m.quicksort(0,m.count);
		m.display();
	}
}
