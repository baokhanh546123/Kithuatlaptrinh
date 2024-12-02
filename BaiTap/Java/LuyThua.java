package Vidu;

public class LuyThua{
    static int coso , mu ;
    static int tinh(){
    	int ketqua = 1;
        for(int i = 1 ; i <= mu ; i++){
            ketqua *= coso;
        }
        return ketqua;
    }
    static void show(int ketqua) {
        System.out.println("Lũy thừa của " + coso + "^" + mu + " là: " + ketqua);
    }
    public static void main (String[] args) {
        LuyThua.coso = 12 ; 
        LuyThua.mu = 2 ;
        int ketqua = LuyThua.tinh();
        LuyThua.show(ketqua);
        
    }
}
