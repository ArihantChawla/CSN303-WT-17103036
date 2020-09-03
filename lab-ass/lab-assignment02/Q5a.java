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

// Code for 5a.

import java.util.*;

public class Main {

    /*
    public static void removeDuplicates(int[] arr){  // Uses Temporary Array
        for(int i = 0; i < arr.length; i++){

        }
    }
    */

    public static int[] union(int[] A, int[] B){
        int C[] = new int[A.length];
        for(int i = 0; i<A.length; i++){
            if( A[i]==1 || B[i]==1) C[i]=1;
            else C[i] = 0;
        }
        return C;
    }


    public static int[] intersection(int[] A, int[] B){
        int C[] = new int[A.length];
        for(int i = 0; i<A.length; i++){
            if(A[i]==1 && B[i]==1) C[i]=1;
            else C[i] = 0;
        }
        return C;
    }

    public static int[] complement(int[] A){
        int C[] = new int[A.length];
        for(int i = 0; i<A.length; i++){
            if(A[i]==1) C[i]=0;
            else C[i] = 1;
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
            int A[] = new int[sizeU]; //hash table, basically
            System.out.print("Enter elements of SetA- ");
            for(int i = 0; i< sizeA; i++){
                int temp = sc.nextInt();
                A[temp] = 1;
            }

            //Input B
            System.out.print("Enter number of elements in SetB- ");
            int sizeB = sc.nextInt();
            int B[] = new int[sizeU]; //hash table, basically
            System.out.print("Enter elements of SetB- ");
            for(int i = 0; i< sizeB; i++){
                int temp = sc.nextInt();
                B[temp] = 1;
            }


            // Op C
            int sizeC = sizeU;
            int[] C = new int[sizeC];

            // union
            long startTime = System.nanoTime();
            C = union(A,B);
            System.out.println("Union:");
            for(int i = 0; i< C.length; i++){
                if(C[i]==1){
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            long stopTime = System.nanoTime();
            System.out.print("Time (in ns): ");
            System.out.println(stopTime - startTime);

            //intersection
            startTime = System.nanoTime();
            C = intersection(A,B);
            System.out.println("Intersection:");
            for(int i = 0; i< C.length; i++){
                if(C[i]==1){
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            stopTime = System.nanoTime();
            System.out.print("Time (in ns): ");
            System.out.println(stopTime - startTime);

            //complement
            startTime = System.nanoTime();
            C = complement(A);
            System.out.println("Complement of A:");
            for(int i = 0; i< C.length; i++){
                if(C[i]==1){
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            stopTime = System.nanoTime();
            System.out.print("Time (in ns): ");
            System.out.println(stopTime - startTime);


    }
}
