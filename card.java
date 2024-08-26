import java.util.ArrayList;
import java.util.List;

public class card {
    String title ; 
    String author ; 
    int amount ;
    List<String[]>store;
    public card(){
        store = new ArrayList<>();
        store.add(new String[]{"Harry Potter","JK Rowling","5"});
        store.add(new String[]{"Conan","Aoyama Gosho","3"});
    }
    public void show(){
        for (String[]book :store){
            System.out.print("Title :" + book[0] + " \n Author: " + book[1] + "\n Amout: " + book[2] + "\n ");
        }
    }
    public static void main(String [] args){
        card cards = new card();
        cards.show();
    }
}

