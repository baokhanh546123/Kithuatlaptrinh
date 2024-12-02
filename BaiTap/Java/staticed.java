package Vidu2;

public class staticed {
	int a;
	public static double Luythua(double a) {
		
		return  (a < 0) ? -1  : Math.pow(a,2);  
	}
	public double phanso(double t , double m) {
		t = staticed.Luythua(t);
		m = staticed.Luythua(m);
		return  t/m;
	}
	public static void main(String[] args) {
       System.out.println(staticed.Luythua(-1));
       staticed s = new staticed();
       System.out.println(s.phanso(1, 2));
    }
	
	
}
