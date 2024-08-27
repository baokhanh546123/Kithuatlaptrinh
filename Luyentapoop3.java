import java.util.Scanner;

public class Main {
    String ma; 
    int sum = 0; 
    
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap IBSN : ");
        ma = sc.nextLine();
    }
    
    public void Check() {
        if (ma.length() != 10) {
            System.out.print("Error! ISBN must be 10 digits.");
        }
    }
    
    public int total() {
        for (int i = 0; i < 10; i++) {
            char c = ma.charAt(i); // Get character at index i
            if (!Character.isDigit(c)) { // Check if the character is not a digit
                System.out.print("ISBN must only contain digits.");
                return -1; // Return -1 to indicate an error
            }
            int digit = Character.getNumericValue(c);
            sum += (i + 1) * digit;
        }
        return sum;
    }
    
    public String check() {
        if (total() == -1) {
            return ""; // Return empty string if there was an error in total()
        }
        String notify = (sum % 11 == 0) ? "Valid ISBN" : "Invalid ISBN";
        return notify;
    }
    
    public static void main(String[] args) {
        Main obj = new Main();
        obj.Nhap();
        obj.Check();
        System.out.print(obj.check());
    }
}
