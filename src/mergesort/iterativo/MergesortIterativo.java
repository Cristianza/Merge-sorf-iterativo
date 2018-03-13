/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort.iterativo;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author lazarod
 */
public class MergesortIterativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamaño;
        System.out.println("Digite el tamaño del vector");
        tamaño = sc.nextInt();
        int[] v = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            v[i] = (int) (Math.random() * 10000) + 1;
        }
        double inicio;
        double total;
        inicio = System.nanoTime();
        sort(v,0,tamaño-1);
        total = System.nanoTime() - inicio;
        for (int i = 0; i < tamaño; i++) {
            System.out.println(v[i]);
        }
        System.out.println("El tiempo que tardo fue: " + total/(1000000000)+ " segundos");
    }
// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r) {
// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }


        /* Merge the temp arrays */
// Initial indexes of first and second subarrays
        int i = 0, j = 0;

// Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r) {
        if (l < r) {
// Find the middle point
            int m = (l + r) / 2;

// Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

// Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}
