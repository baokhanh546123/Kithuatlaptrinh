package Vidu;

public class Count_Sort {
    int size, count;
    int[] a;

    public Count_Sort(int size) {
        this.a = new int[size];
        this.size = size;
        this.count = -1;
    }

    public void push(int data) {
        if (count < size - 1) {  // Allow adding elements if the array is not full
            count++;
            a[count] = data;
            System.out.println("Added: " + data);
        } else {
            System.out.println("FULL");
        }
    }

    public void sort() {
        // Initialize the output array
        int[] output = new int[count + 1];

        // Find the maximum element to determine the range of the count array
        int max = a[0];
        for (int i = 1; i <= count; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // Initialize the count array
        int[] countArray = new int[max + 1];

        // Count occurrences of each element in the array
        for (int i = 0; i <= count; i++) {
            countArray[a[i]]++;
        }

        // Update the count array to hold actual positions
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the output array
        for (int i = count; i >= 0; i--) {
            output[countArray[a[i]] - 1] = a[i];
            countArray[a[i]]--;
        }

        // Copy the sorted elements back to the original array
        for (int i = 0; i <= count; i++) {
            a[i] = output[i];
        }
    }

    public void displayArray() {
        for (int i = 0; i <= count; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Count_Sort sorter = new Count_Sort(5);
        sorter.push(4);
        sorter.push(2);
        sorter.push(2);
        sorter.push(8);
        sorter.push(3);

        System.out.println("Before sorting:");
        sorter.displayArray();

        sorter.sort();

        System.out.println("After sorting:");
        sorter.displayArray();
    }
}
