package Vidu3;

import java.util.Scanner;


public class nhap implements begin {
	Scanner sc = new Scanner(System.in);
	String name , classed  ; 
	public String nhap() {
		System.out.println("Nhap ten :");
		name = sc.nextLine();
		System.out.println("Nhap lop :");
		classed = sc.nextLine();
	}
	public void xuat() {
		System.out.println("Ten la :" + name );
		System.out.println("Lop la :" + classed );
	}
	public void capnhat(String name , String classed) {
		this.name = name ; 
		this.classed = classed ;
	}
}
