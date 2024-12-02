import java.util.*;
import java.io.*;

public class Paroline {
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    String paroline = new StringBuilder().reserve().toString();
    if (A.equals(paroline)){
      System.out.print("Yes");
  }else{
      System.out.print("No");
    }
}
}
