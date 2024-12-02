public class hinhtrong{
    protected double r;
    public hinhtrong(double r ){
        this.r = r ; 
    }
    public double Dientich(){
        double s =3.14*2*r*r;
        return s ; 
    }
    public void xuat(int s ){
        System.out.print("Dien tich la " + s );
    }
    
}
//FIle hinhcau.java
public class hinhcau extends hinhtrong{
    public hinhcau(double r){
        super(r); 
    }
    public double dientichhinhcau(){
        double S = 4*3.14*r*r;
        return S;
    }
    public double thetichhinhcau(){
        double V = (4/3)*(Math.PI)*(Math.pow(r,3));
        return V;
    }
    public static void main (String[] args) {
        hinhtrong t = new hinhtrong(14.75);
        System.out.println(t.Dientich());
        hinhcau c = new hinhcau(3.5);
        System.out.println(c.dientichhinhcau());
        System.out.println(c.thetichhinhcau());
    }
}
