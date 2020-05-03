package SortingAlgo;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) a[i] = StdRandom.uniform(20);
        StdOut.println("Unsorted: " + Arrays.toString(a));
        QuickSort q = new QuickSort();
        q.sort(a);
        StdOut.println("Sorted: " + Arrays.toString(a));
    }

    public void sort(Integer[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Integer[] a, int low, int high) {
        if (low >= high) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private void swap(Integer[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int partition(Integer[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (a[low] > a[++i]) {
                if (i == high) break;
            }
            while (a[low] < a[--j]) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }
}