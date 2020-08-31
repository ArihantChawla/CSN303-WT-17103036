/*
 * Q3. Write a program to sort strings (without using library function).
 */

public class Main {

    public static int findStrLen(String s){
        char ca[] = s.toCharArray();
        int i = 0;
        for(char c:ca) i++;
        return i;
    }

    public static String sort(String s){ // imma do bubble sort :)
        int size = findStrLen(s);
        char ca[] = s.toCharArray();
        for (int i = 0; i < size-1; i++)  {
            for (int j = 0; j < size-i-1; j++) {
                if (ca[j] > ca[j+1]) {
                    char temp = ca[j];
                    ca[j] = ca[j+1];
                    ca[j+1] = temp;
                }
            }
       }
       return new String(ca);
    }

    public static void main (String[]args) {
        String s = "chaachahcch";
        //    String s = "";
        //    String s = "chaachbhcch";
        //    String s = "chaachahcc";
        //    String s = "dsaxdccsccdc";

        //
        System.out.println("String before sorting");
        System.out.println(s);

        String op = sort(s);

        System.out.println("String after sorting");
        System.out.println(op);
    }
}
