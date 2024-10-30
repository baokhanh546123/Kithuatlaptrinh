package Vidu;
public class phanso1 extends UocNhoNhat {
	int tuso , mauso ;
	public phanso1() {
		tuso = 0 ; 
		mauso = 1 ;
	}
	public phanso1(int x , int y ) {
		tuso = x ;
		mauso = y ;
		rutgon();
	}
	void rutgon() {
		int gcd = UocNhoNhat.find(tuso, mauso);
		this.tuso /= gcd;
		this.mauso /= gcd;
	}
	public phanso1 tong(phanso1 ob1 , phanso1 ob2) {
		int newmauso = ob1.mauso * ob2.mauso;
		int newtuso = (ob1.tuso*ob2.mauso) + (ob2.tuso*ob1.mauso);
		return new phanso1(newtuso,newmauso);
	}
	public phanso1 hieu(phanso1 ob1 , phanso1 ob2) {
		int newmauso = ob1.mauso * ob2.mauso;
		int newtuso = (ob1.tuso*ob2.mauso) - (ob2.tuso*ob1.mauso);
		return new phanso1(newtuso,newmauso);
	}
	public phanso1 tich(phanso1 ob1 , phanso1 ob2) {
		int newtuso = ob1.tuso * ob2.tuso;
		int newmauso = ob1.mauso * ob2.mauso;
		return new phanso1(newtuso,newmauso);
	}
	public phanso1 thuong(phanso1 ob1 , phanso1 ob2) {
		if (ob2.mauso == 0) {
			System.out.println("Loi");
		}
		int newtuso = ob1.tuso * ob2.mauso;
		int newmauso = ob1.mauso * ob2.tuso;
		return new phanso1(newtuso,newmauso);
	}
	public phanso1 sosanh(phanso1 ob1 , phanso1 ob2) {
		int newmauso = ob1.mauso * ob2.mauso;
		int newtuso1 = ob1.tuso * ob2.mauso;
		int newtuso2 = ob2.tuso * ob1.mauso;
		if (newtuso1 > newtuso2) {
			System.out.println(ob1.tuso + "/" + ob1.mauso + " > " + ob2.tuso + "/" + ob2.mauso);
		}else if (newtuso1 < newtuso2) {
			System.out.println(ob1.tuso + "/" + ob1.mauso + " < " + ob2.tuso + "/" + ob2.mauso);
		}else {
			System.out.println(ob1.tuso + "/" + ob1.mauso + " = " + ob2.tuso + "/" + ob2.mauso);
		}
		return null;
	}
	public phanso1 tang() {
	    this.tuso += this.mauso; // Tăng tử số lên bằng mẫu số
	    rutgon(); // Rút gọn phân số
	    return this; // Trả về đối tượng phân số hiện tại
	}

	
	public void show() {
		System.out.println("Phan so la " + tuso + "/" + mauso );
	}
	
	public static void main(String[] args) {
		 phanso1 ps1 = new phanso1(168, 48); 
	     phanso1 ps2 = new phanso1(108, 42);
	     ps1.show();
	     ps2.show();
	     phanso1 result = ps1.tong(ps1, ps2);
	     result.show(); 
	     phanso1 result2 = ps1.hieu(ps1, ps2);
	     result2.show();
	     phanso1 result3 = ps1.tich(ps1, ps2);
	     result3.show();
	     phanso1 result4 = ps1.thuong(ps1, ps2);
	     result4.show();
	     ps1.sosanh(ps1, ps2);
	     phanso1 result5 = ps1.tang();
	     result5.show();
	     
	}
}
