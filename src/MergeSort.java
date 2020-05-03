
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        //Create class Object
        MergeSort ms = new MergeSort();

        //Initialize an array of N random numbers between 0 and N
        Integer[] a = ms.init(args[0]);
        StdOut.println("Unsorted Array: " + Arrays.toString(a));
        ms.sort(a, 0, a.length - 1);
        StdOut.println("Sorted Array: "+Arrays.toString(a));
    }

    private Integer[] init(String num) {
        Integer[] a = new Integer[Integer.parseInt(num)];
        for (int i = 0; i < a.length; i++) a[i] = StdRandom.uniform(a.length*4);
        return a;
    }

    private void sort(Integer[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(Integer[] a, int low, int mid, int high) {
        Integer[] L = Arrays.copyOfRange(a, low, mid + 1);
        Integer[] R = Arrays.copyOfRange(a, mid + 1, high + 1);
        int i = 0;
        int j = 0;
        int k = low;
        while (i < L.length && j < R.length) {
            if (L[i] >= R[j]) a[k++] = R[j++];
            else a[k++] = L[i++];
        }
        /* Copy remaining elements of L[] if any */
        while (i < L.length) a[k++] = L[i++];
        /* Copy remaining elements of R[] if any */
        while (j < R.length) a[k++] = R[j++];
    }
}