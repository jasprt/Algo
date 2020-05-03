package SortingAlgo;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(10);
        }
        StdOut.println("Random Unsorted Array: " + Arrays.toString(a));
        new SelectionSort().sort(a, 'A');
        StdOut.println("Sorted Array in Asc: " + Arrays.toString(a));
        new SelectionSort().sort(a, 'D');
        StdOut.println("Sorted Array in Desc: " + Arrays.toString(a));

    }

    private boolean compare(int a, int b, char c) {

        switch (c) {
            case 'A':
                return a > b;
            case 'D':
                return a < b;
            default:
                throw new IllegalArgumentException("Either A or D char allowed for ascending and descending order sort respectively");
        }
    }

    private void swap(Integer[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void sort(Integer[] a, char c) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (compare(a[min], a[j], c)) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

}