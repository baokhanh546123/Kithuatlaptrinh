package Vidu;

public class Main2 {

	public static void main(String[] args) {
		Hinhhoc[] h = {new Hinhtron(4) , new Hinhchunhat(8,4) , new Hinhtron(7.99)};
		System.out.println("Dien tich la");
		for (int i = 0 ; i < h.length ; i++) {
			System.out.println(h[i].Dientich());
		}
	}

}
