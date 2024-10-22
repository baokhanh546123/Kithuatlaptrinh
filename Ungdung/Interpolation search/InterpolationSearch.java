public class InterpolationSearch {
    int search(int[] a, int n, int x) {
        int low = 0;
        int high = n - 1;
        int mid;
        while (a[high] != a[low] && x >= a[low] && x <= a[high]) {
            // Tính giá trị mid theo công thức Interpolation
            mid = low + ((x - a[low]) * (high - low) / (a[high] - a[low]));
            if (a[mid] == x) {
                return mid;  
            }
            if (a[mid] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1; 
    }
    public static void main(String[] args) {
        InterpolationSearch searcher = new InterpolationSearch();
        int[] a = {10, 12, 23, 32, 35, 42, 47, 51, 53, 60};  
        int x = 42;
        int result = searcher.search(a, a.length, x);
        if (result != -1) {
            System.out.println("Giá trị " + x + " được tìm thấy tại chỉ số: " + result);
        } else {
            System.out.println("Giá trị " + x + " không có trong mảng.");
        }
    }
}
