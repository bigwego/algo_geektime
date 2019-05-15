package sort;

import java.util.List;
import java.util.Random;

public class Sorts {

    // Bubble Sort
    private static void bubbleSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean hasSwaped = false;
            for (int j = n - 1; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    hasSwaped = true;
                }
            }
            if (!hasSwaped) {
                break;
            }
        }
    }

    // Insertion Sort
    private static void insertionSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int val = a[i];
            int j = i - 1;
            for (; j > -1; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
    }

    //Merge Sort
    private static void mergeSort(int[] a, int n) {
        mergeSort(a, 0, n - 1);
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int idx = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                tmp[idx++] = a[i++];
            } else {
                tmp[idx++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[idx++] = a[i++];
        }
        while (j <= r) {
            tmp[idx++] = a[j++];
        }
        for (int k = l; k <= r; k++) {
            a[k] = tmp[k - l];
        }
    }

    // Quick Sort
    private static void quickSort(int[] a, int n) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] < pivot) {
                swap(a, i++, j);
            }
        }
        swap(a, i, r);
        System.out.println("i=" + i);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void printAll(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        int[] arr = generateArr();
//        printAll(arr);
//        long s = System.currentTimeMillis();
//        bubbleSort(arr, arr.length);
//        long e = System.currentTimeMillis();
//        printAll(arr);
//        System.out.println(e - s);
//
//        arr = generateArr();
//        printAll(arr);
//        s = System.currentTimeMillis();
//        insertionSort(arr, arr.length);
//        e = System.currentTimeMillis();
//        printAll(arr);
//        System.out.println(e - s);

        int[] arr = generateArr();
        long s = System.currentTimeMillis();
        quickSort(arr, arr.length);
        long e = System.currentTimeMillis();
        printAll(arr);
        System.out.println(e - s);
    }


    private static void doBubbleSort(List<int[]> arrs) {
        for (int[] arr : arrs) {
            bubbleSort(arr, arr.length);
        }
    }

    private static void doInsertSort(List<int[]> arrs) {
        for (int[] arr : arrs) {
            insertionSort(arr, arr.length);
        }
    }

    private static int[] generateArr() {
        Random rand = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = rand.nextInt(2500);
        }
        return arr;
    }
}
