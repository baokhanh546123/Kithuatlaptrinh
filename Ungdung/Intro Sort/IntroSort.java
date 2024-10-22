package Sort;
public class IntroSort {
    int[] a;
    int n;
    public IntroSort(int size) {
        this.a = new int[size];
        this.n = 0;
    }
    void push(int data) {
        if (n < a.length) {
            a[n++] = data;
            System.out.println("Added: " + data);
        } else {
            System.out.println("Array is full!");
        }
    }
    void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void maxHeap(int i, int heapN, int low) {
        int temp = a[low + i - 1];
        int c;
        while (i <= heapN / 2) {
            c = 2 * i;
            if (c < heapN && a[low + c - 1] < a[low + c]) {
                c++;
            }
            if (temp >= a[low + c - 1]) {
                break;
            }
            a[low + i - 1] = a[low + c - 1];
            i = c;
        }
        a[low + i - 1] = temp;
    }
    void heapify(int low, int high, int heapN) {
        for (int i = heapN / 2; i >= 1; i--) {
            maxHeap(i, high, low);
        }
    }

    // Heapsort
    void heapsort(int low, int high) {
        int heapN = high - low;
        heapify(low, high, heapN);
        for (int i = heapN; i >= 1; i--) {
            swap(low, low + i);
            maxHeap(i, high, low);
        }
    }

    // insertsort
    void insertion(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= left && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
    // tim phan tu median
    int find(int a1, int b1, int c1) {
        int max = Math.max(Math.max(a[a1], a[b1]), a[c1]);
        int min = Math.min(Math.min(a[a1], a[b1]), a[c1]);
        int median = max ^ min ^ a[a1] ^ a[b1] ^ a[c1];
        if (median == a[a1]) {
            return a1;
        }
        if (median == a[b1]) {
            return b1;
        }
        return c1;
    }
    // partition cua quicksort
    int partition(int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
    // sort
    void sortdatautil(int low, int high, int depthlimit) {
        if (high - low > 16) {
            if (depthlimit == 0) {
                heapsort(low, high);
                return;
            }
            depthlimit = depthlimit - 1;
            int pivot = find(low, low + ((high - low) / 2) + 1, high);
            swap(pivot, high);
            int p = partition(low, high);
            sortdatautil(low, p - 1, depthlimit);
            sortdatautil(p + 1, high, depthlimit);
        } else {
            insertion(low, high);
        }
    }

    // sort
    void sortdata() {
        int depthlimit = (int) (2 * Math.floor(Math.log(n) / Math.log(2)));
        sortdatautil(0, n - 1, depthlimit);
    }

    // in mang
    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] inp = {2, 10, 24, 12, 85, 72, 91, 43};
        IntroSort sorter = new IntroSort(inp.length);
        for (int num : inp) {
            sorter.push(num);
        }
        sorter.sortdata();
        sorter.display();
    }
}
