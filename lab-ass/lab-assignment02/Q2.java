/*
 * Q2. Write a program to implement counting sort (with input in the range 0 to 20 and input can be repeated multiple times)
 */


import java.util.Random;


public class Main {

    public static void countingSort(int arr[]){
        int size = arr.length;
        int op[] =  new int[size];

        int count[] = new int[20]; // I'm assuming [0,20) (discretized at ints), ie. 20 not included.
        for(int i = 0; i<size; i++){
            count[arr[i]]++;     // basically hashing, or index tables, or TLBs, whateva...
        }

        for(int i =0; i < 20; i++){
            while(count[i]>0){
                System.out.print(i);
                System.out.print(" ");
                count[i]--;
            }
        }
        System.out.print("\n");
    }

    public static void main (String[]args)
    {
        int size = 100;
        int arr[] = new int[size];

        Random rn = new Random();
        for(int i = 0; i < size; i++){
            arr[i] = rn.nextInt(20);
            //arr[i] = i % 20;

        }

        // Array before sorting;
        System.out.println("Array before sorting");
        for(int i =0; i < size; i++){
                System.out.print(arr[i]);
                System.out.print(" ");
        }
        System.out.print("\n");

        // Array after sorting;
        System.out.println("Array after count-sorting");
        countingSort(arr);
    }

}
