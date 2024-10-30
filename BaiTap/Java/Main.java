package Vidu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack s = new stack(3);
		s.add(9);
		s.add(4);
		s.add(5);
		System.out.println("IS FULL :" + s.isFull());
		s.pop();
		s.display();
		s.pop();
		s.display();
		s.pop();
		s.display();
		System.out.println("IS Empty :" + s.isEmpty());
		System.out.println("Queue");
		queue q = new queue(3);
		q.push(4);
		q.display();
		q.push(5);
		q.display();
		q.push(8);
		q.display();
		System.out.println("IS FULL :" + q.isFull());
		q.pop();
		q.pop();
		q.pop();
		q.display();
		System.out.println("IS Empty :" + s.isEmpty());
		System.out.println("Quan li sach");
		Quanli p = new Quanli();
		p.input();
		p.display();
	}
	
}
