/*
 * 6. Write a ConsoleProgram that reads in a number from the user and then displays the Hailstone sequence for that number \
 * (Pick some positive integer and call it n. If n is even, divide it by two. If n is odd, multiply it by three and add one. Continue this process until n is equal to one)
 */

import java.util.*;

public class Main
{
	    public static void main(String[]args){
	        Scanner sc=new Scanner(System.in);
	        System.out.print("Enter number- ");
            int n = sc.nextInt();
            System.out.print(n);
            System.out.print(" ");
            while(n!=1){
                if(n%2==1){
                    n = n*3 +1;
                }
                else{
                    n = n/2;
                }
                System.out.print(n);
                System.out.print(" ");
            }
            System.out.print("\n");
	    }
}
