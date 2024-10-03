import java.util.*;
public class Solution{
  public static String getSmallestAndLargest(String s , int k ){
    String smallest = s.substring(0,k);
    String largest = s.substring(0,k);

    for (int i = 1 ; i <= s.length() - k ; i++){
      String substring = s.substring(i,i+k);
      if (substring.compareTo(smallest) < 0){
        smallest = substring;
      }
      if (substring.compareTo(largest) > 0){
        largest = substring;
      }  
    }
    return smallest + "\n" + largest ;
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    int k = sc.nextInt();
    sc.close();
    System.out.println(getSmallestAndLargest(s, k));
    
  }
}
