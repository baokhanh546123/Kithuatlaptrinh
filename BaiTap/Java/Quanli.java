package Vidu;
import java.util.Scanner;
public class Quanli {
	String title , author;
	int amount ,size , index , ID; 
	String [] Q ; 
	Scanner sc = new Scanner(System.in);
	
	public Quanli() {
		System.out.println("Times: ");
		this.size = sc.nextInt() ;
		this.index = 0;
		this.ID = 1 ;
		Q = new String [size];
		sc.nextLine();
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0 ; i < size ; i++) {
			System.out.print("Enter to title of the book : ");
			title = sc.nextLine();
			System.out.print("Enter to author of the book : ");
			author = sc.nextLine();
			System.out.print("Enter to amount of the book : ");
			amount = sc.nextInt();
			sc.nextLine();
			store();
		}
	}
	
	public void store() {
		if (amount > 0 ) {
			if (index < Q.length) {
				Q[index] ="ID:"+ ID + ", Title " + title + ", Author " + author + ", Amount " + amount ;
				System.out.println("Success");
				System.out.println(Q[index]);
				index ++;
				ID ++;
			}
		}else {
			System.out.println("Failed");
		}
		
	}
	public void display() {
		 if (index == 0) {
	            System.out.println("No books available.");
	        } else {
	            System.out.println("List of books:");
	            for (int i = 0; i < index; i++) {
	                System.out.println(Q[i]);
	            }
	        }
	}
}
