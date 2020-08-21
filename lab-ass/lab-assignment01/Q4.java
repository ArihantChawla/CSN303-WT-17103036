/* Q4: Anagrams
 *
 */

import java.util.Arrays; //for sorting the string 


public class Q4
{
    // Fucntion that i/ps string and returns sorted string
    public static String sortString(String ipString){
        char temp[] = ipString.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
    
    
    public static boolean areAnagram(String s1, String s2){
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        if (l1 == 0 && l2 == 0) return false;
        if (l1 != l2) return false;
        //s1 = sortString(s1); // strings are non mutable. can't do this 
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i =0; i< l1; i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		//String a = sortString("java");
		//System.out.println("String a: " + a);
		
		// Test cases can be added on ad hoc basis
		String a = "acha";
		String b = "chaa";
		boolean check = areAnagram(a,b);
		System.out.println(check);
	}
}

