package sort;

import java.util.Random;

public class CountingSort {

    private static void coutingSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        int max = a[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, a[i]);
        }

        int[] cnts = new int[max + 1];
        for (int num : a) {
            cnts[num]++;
        }

        for (int i = 1; i <= max; i++) {
            cnts[i] += cnts[i - 1];
        }

        int[] tmp = new int[n];
        for (int num : a) {
            tmp[--cnts[num]] = num;
        }

        for (int i = 0; i < n; i++) {
            a[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        Random rand = new Random();
        for (int i = 0, len = a.length; i < len; i++) {
            a[i] = rand.nextInt(100);
        }
        coutingSort(a, a.length);
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
