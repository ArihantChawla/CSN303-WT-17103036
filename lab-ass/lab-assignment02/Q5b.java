/*
 * 5. Let us define a couple of sets of integers,
 * and let Java compute the set-theoretical operations
 * (union, intersection and complement).
 * We first fix our universe, which will consist of the 11 elements,
 * Universe = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, A and B will be entered by users.
    a. Only array can be used as data structure
    b. Using any efficient data-structure available in Java
    c. Compare the time to compute the operations
 */

// Code for 5b.

import java.util.*;

public class Main {


    public static HashSet<Integer> union(HashSet<Integer> A, HashSet<Integer> B){
    HashSet<Integer> C = new HashSet<Integer>();
        for(int i = 0; i<11; i++){
            if( A.contains(i) || B.contains(i)) C.add(i);
        }
        return C;
    }


    public static HashSet<Integer> intersection(HashSet<Integer> A, HashSet<Integer> B){
    HashSet<Integer> C = new HashSet<Integer>();
        for(int i = 0; i<11; i++){
            if( A.contains(i) && B.contains(i)) C.add(i);
        }
        return C;
    }

    public static HashSet<Integer> complement(HashSet<Integer> A){
    HashSet<Integer> C = new HashSet<Integer>();
        for(int i = 0; i<11; i++){
            if(A.contains(i)) continue;
            else C.add(i);
        }
        return C;
    }




    public static void main (String[]args) {
            int[] U = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Scanner sc=new Scanner(System.in);
            int sizeU = U.length;

            //Input A
            System.out.print("Enter number of elements in SetA- ");
            int sizeA = sc.nextInt();
            //int A[] = new int[sizeU]; //hash table, basically
            HashSet<Integer> A = new HashSet<Integer>();
            System.out.print("Enter elements of SetA- ");
            for(int i = 0; i< sizeA; i++){
                int temp = sc.nextInt();
                A.add(temp);
            }

            //Input B
            System.out.print("Enter number of elements in SetB- ");
            int sizeB = sc.nextInt();
            //int B[] = new int[sizeU]; //hash table, basically
            HashSet<Integer> B = new HashSet<Integer>();
            System.out.print("Enter elements of SetB- ");
            for(int i = 0; i< sizeB; i++){
                int temp = sc.nextInt();
                B.add(temp);
            }


            // Op C
            HashSet<Integer> C = new HashSet<Integer>();

            // union
            long startTime = System.nanoTime();
            C = union(A,B);
            System.out.println("Union:");
            System.out.println(C);

            long stopTime = System.nanoTime();
            System.out.print("Time (in ns): ");
            System.out.println(stopTime - startTime);

            //intersection
            startTime = System.nanoTime();
            C = intersection(A,B);
            System.out.println("Intersection:");
            System.out.println(C);

            stopTime = System.nanoTime();
            System.out.print("Time (in ns): ");
            System.out.println(stopTime - startTime);

            //complement
            startTime = System.nanoTime();
            C = complement(A);
            System.out.println("Complement of A:");
            System.out.println(C);

            stopTime = System.nanoTime();
            System.out.print("Time (in ns): ");
            System.out.println(stopTime - startTime);


    }
}
