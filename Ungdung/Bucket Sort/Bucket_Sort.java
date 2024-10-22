package Sort;
import java.util.*;
public class BucketSort {
    int size, count;
    float[] a;
    public BucketSort(int size) {
        this.size = size;
        this.count = -1;
        this.a = new float[size];
    }
    void push(float data) {
        if (count < size - 1) {
            count++;
            a[count] = data;
            System.out.println("Added to " + data);
        } else {
            System.out.println("Full");
        }
    }
    // insertion sort
    void insertsort(ArrayList<Float> bucket) {
        int n = bucket.size();
        for (int i = 1; i < n; i++) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
    void bucketsort() {
        int n = a.length;
        // tao mang rong
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // throw no vao bucket
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * a[i]);  
            buckets[bi].add(a[i]);
        }

        // Sap xep
        for (int i = 0; i < n; i++) {
            insertsort(buckets[i]);
        }

        //match voi mang ban dau
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                a[index++] = buckets[i].get(j);
            }
        }
    }

    // Hàm in mảng
    void display() {
        for (int i = 0; i <= count; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BucketSort bs = new BucketSort(10);
        bs.push(0.42f);
        bs.push(0.32f);
        bs.push(0.23f);
        bs.push(0.15f);
        bs.push(0.27f);
        bs.push(0.51f);
        bs.push(0.71f);
        bs.push(0.91f);
        bs.push(0.66f);
        bs.push(0.85f);

        System.out.println("Before sort:");
        bs.display();

        bs.bucketsort();

        System.out.println("After sort:");
        bs.display();
    }
}
