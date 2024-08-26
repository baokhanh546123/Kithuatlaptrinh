public class Phanso{
    int t ; 
    int m ;
    public Phanso(){
        t = 0 ; 
        m = 1 ; 
    }
    public Phanso(int x ){
        t = x ; 
        m = 1 ; 
    }
    public Phanso(int x , int y ){
        t = x ; 
        m = y ;
    }
    public void show(){
        System.out.print(t + "/" + m );
    }
}
public class Main{
    public static void main(String[] args) {
        Phanso A = new Phanso();
        A.show();
    }
}
