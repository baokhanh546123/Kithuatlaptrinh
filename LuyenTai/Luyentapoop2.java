import java.util.Scanner;

public class Main {
    String P; 
    
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ki tu: ");
        P = sc.nextLine();
    }
    
    public String Upper() {
        String first = P.substring(0, 1);
        String last = P.substring(1, P.length());
        String first_upper = first.toUpperCase();
        P = first_upper + last; 
        return P;
    }
    
    public static void main(String[] args) {
        Main obj = new Main();
        obj.Nhap();
        System.out.print(obj.Upper());
    }
}
