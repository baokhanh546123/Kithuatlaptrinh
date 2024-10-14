import java.io.*;
import java.util.*;
public class Anagram {
  public static boolean isAnagram(String a , String b ){
    a = a.toLowerCase();
    b = b.toLowerCase();

    if (a.length() != b.length() ){
      return false;
    }
    int [] charCount = new int [26];
    for(int i = 0 ; i <= a.length() ; i++){
      charCount[a.charArt(i) - 'a']++;
    }
    for(int j = 0 ; j <= b.length() ; i++){
      charCount[a.charArt(j) - 'a']--;
    }
    for (int count : charCount){
      if (count != 0 ){
        return false;
      }
  }
    return true;
}
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    String a ,b  ;
    a = sc.next();
    b = sc.next();
    sc.close();
    boolean re = isAngram(a,b);
    if (re){
      System.out.println("Anagrams");
    }else {
            System.out.println("Not Anagrams");
        }
  }
