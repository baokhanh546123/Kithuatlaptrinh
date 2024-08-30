import java.util.Scanner;

public class Main{
    int so_du = 1000000000 ; 
    int receive ;
    int send ; 
    
    
    public int Gift(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter to money : ");
        receive = sc.nextInt();
        so_du += receive;
        System.out.println("Success");
        return so_du;
    }
    public int Rel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter to money : ");
        send = sc.nextInt();
        so_du -= send;
        System.out.println("Success");
        return so_du;
    }
    public void Check(){
        System.out.println("Money Bank is " + so_du + "VND");
    }
    public int Nhap(){
        Scanner sc = new Scanner(System.in);
        while (true) { 
            System.out.println("Hello My friend this is ATM ");
            System.out.println("1.Receive");
            System.out.println("2.Send");
            System.out.println("3.Check");
            System.out.println("4.End");
            
            
            System.out.print("Choose : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1 : 
                    Gift();
                    break;
                case 2 : 
                    Rel();
                    break;
                case 3 : 
                    Check();
                    break;
                case 4 : 
                    System.out.println("Thank fucking shit u !");
                    System.exit(0);
                default:
                System.out.println("Invalid , fuck you please choose against ");
            }
        
        }
        
    }
    public static void main (String[] args) {
        Main obj = new Main();
        obj.Nhap();
    }
}
