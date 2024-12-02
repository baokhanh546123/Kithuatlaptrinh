package Vidu;
public class kiemtra{
    static int i ; 

    public void set_i(int n){
        i = n ;
    }

    public int get_i(){
        return i;
    }

    public static void main (String[] args) {
        kiemtra ob1 = new kiemtra();
        kiemtra ob2 = new kiemtra();
        ob1.set_i(10);
        System.out.println("Gia tri cua ob1: " + ob1.get_i()); // in ra 10
        System.out.println("Gia tri cua ob2: " + ob2.get_i()); // in ra 10
        kiemtra.i = 100; 
        System.out.println("Sau khi thay doi kiemtra.i = 100");
        System.out.println("Gia tri cua ob1: " + ob1.get_i()); // in ra 100
        System.out.println("Gia tri cua ob2: " + ob2.get_i()); // in ra 100
    }
}
