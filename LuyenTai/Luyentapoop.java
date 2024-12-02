import java.util.Scanner;
public class Main
{
    String P ; 
    
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ki tu: ");
        P = sc.nextLine();
    }
    
    public String Space(){
        return P.replaceAll(" ","");
    }
    
    
    public static void main (String[] args) {
        Main obj = new Main();
        obj.Nhap();
        System.out.print(obj.Space());
    }
}
