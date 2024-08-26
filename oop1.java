import java.util.Scanner;

class ps {
    int a; 
    int b;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu: ");
        a = sc.nextInt();
        System.out.print("Nhap mau: ");
        b = sc.nextInt();
    }
    public void xuat() {
        if (a == 0 && b != 0) {
            System.out.println(0);
        } else if (a != 0 && b == 0) {
            System.out.println("Loi");
        } else {
            System.out.println("Phan so la : "+a+"/"+b);
        }
    }
}

public class oop1 {
    public static void main(String[] args) {
        ps obj1 = new ps();
        obj1.nhap();
        obj1.xuat();
    }
}
