package Vidu2;

public class Test {

    // Method to compute factorial of a number
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Method to compute the product as per your formula
    public double computeProduct(int x, int n) {
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result *= (double) x / factorial(i); // Calculate x / i! and multiply
        }
        return result;
    }

    public static void main(String[] args) {
        Test t = new Test();
        double kq = t.computeProduct(1,1); // Example: x = 5, n = 4
        System.out.println(kq);
    }
}
