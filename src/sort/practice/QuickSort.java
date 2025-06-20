package sort.practice;

import java.util.Scanner;

/**
 * ClassName: QuickSort
 * Package: sort.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-05-06 13:34
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        String[] data = line.split("\\s+");
        int[] dataInt = new int[data.length];
        for (int i = 0; i < dataInt.length; i++) {
            dataInt[i] = Integer.parseInt(data[i]);
        }
        mergeSort(dataInt, 0, dataInt.length - 1);
        for (int i : dataInt) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int i = left - 1, j = right + 1, pivot = arr[(left+right) >> 1];
        while (i < j) {
            do {
                i++;
                System.out.println(i  + " " + arr[i]);
            } while(arr[i] < pivot);
            do {
                j--;
                System.out.println(j  + " " + arr[j]);
            } while(arr[j] > pivot);
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("swap" + arr[i] + " " + arr[j]);
            }
        }
        for (int i1 : arr) {
            System.out.print(i1);
        }
        System.out.println();
        System.out.println("left section: [" + left + ", " + j + "]");
        quickSort(arr, left, j);
        System.out.println("right section: [" + (j+1) + ", " + right + "]");
        quickSort(arr, j+1, right);
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left, j = right, pivot = arr[(left + right) >> 1];
        while (i <= j) {
            while (i <= j && arr[i] < pivot) {
                i++;
                System.out.println(i  + " " + arr[i]);
            }
            while (i <= j && arr[j] > pivot) {
                j--;
                System.out.println(j  + " " + arr[j]);
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("swap" + arr[i] + " " + arr[j]);
                i++;
                j--;
            }
        }
        for (int i1 : arr) {
            System.out.print(i1);
        }
        System.out.println();
        System.out.println("left section: [" + left + ", " + j + "]");
        quickSort2(arr, left, j);
        System.out.println("right section: [" + i + ", " + right + "]");
        System.out.println("Wrong section: [" + (j+1) + ", " + right + "]");
        quickSort2(arr, i, right);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        int mainPointer = 0, i = left, j = mid+1;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                temp[mainPointer] = arr[i];
                i++;
            } else {
                temp[mainPointer] = arr[j];
                j++;
            }
            mainPointer++;
        }
        while (i <= mid) {
            temp[mainPointer] = arr[i];
            mainPointer++;
            i++;
        }
        while (j <= right) {
            temp[mainPointer] = arr[j];
            mainPointer++;
            j++;
        }
        for (int x = 0, y = left; y <= right ; x++, y++) {
            arr[y] = temp[x];
        }
    }
}
