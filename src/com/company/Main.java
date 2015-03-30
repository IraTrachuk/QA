package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    /*   Scanner scn = new Scanner(System.in);
        int a,b;
        System.out.println("Enter a:");
        a = scn.nextInt();
        System.out.println("Enter b:");
        b = scn.nextInt();
        System.out.println("Sum is " + (a+b));
     */
      int[] arr1 = {1, 2, 3, 4, 5, 6};
      System.out.println(Arrays.toString(arr1));

        for (int i:arr1)
            System.out.println(i);

       String[] arr2 = {"Me", "Myself", "I"};
       String[] arr3 = {"1", "2", "3"};

        for (int i = 0; i<arr2.length; i++)
            System.out.println(arr2[i] + "-" + arr3[i]);




    }
}
