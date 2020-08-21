/* 
 * Q1: No of instances of substring in a given string
 */


public class Q1
{
    
  public static int countInstances(String p, String s){
      int count = 0;    
      for(int i = 0; i< p.length(); i++){
          if(p.indexOf(s,i) == i){     // indexOf returns the index of the first occurance of substring s in the string p. The second parameter is used to provide starting index. 
              count++;
          }
      }
      return count;
  }    
  public static void main (String[]args)
  {
    String primaryString = "chaachahcch";
	String searchSubstring = "ch";
    System.out.println(countInstances(primaryString,searchSubstring));
  }
}

