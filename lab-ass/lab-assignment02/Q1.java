/*
 * Q1. Write a java program to compare two strings lexicographically (without using library function).
 */

public class Main {

    public static int findStrLen(String s){
        char ca[] = s.toCharArray();
        int i = 0;
        for(char c:ca) i++;
        return i;
    }

    public static int compare(String s1, String s2){
        char ca1[] = s1.toCharArray();
        char ca2[] = s2.toCharArray();
        int n;
        int len1 = findStrLen(s1);
        int len2 = findStrLen(s2);

        if(len1>len2) n = len2;
        else n = len1;

        for(int i = 0; i< n; i++){
            if((int)ca1[i]>(int)ca2[i]){     // indexOf returns the index of the first occurance of substring s in the string p. The second parameter is used to provide starting index.
                return -1;
            }
            else if((int)ca2[i]>(int)ca1[i]){
                return 1;
            }
            else continue;
        }
        if(len1>len2) return -1;
        else if (len2> len1) return 1;
        else return 0;
    }

    public static void main (String[]args) {
        String s1 = "chaachahcch";
        //    String s1 = "";
        //    String s2 = "";
        String s2 = "chaachbhcch";
        //    String s2 = "chaachahcc";
        //    String s2 = "dsaxdccsccdc";
        int x = compare(s1, s2);
        if(x==0) System.out.println("Both Strings are equal");
        if(x==-1) System.out.println("String1 is lexographically greater");
        if(x==1) System.out.println("String2 is lexographically greater");
    }
}
