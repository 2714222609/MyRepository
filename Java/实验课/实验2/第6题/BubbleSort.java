package java_test2;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{12, 5, 32, 52, 2, 26, 68};
        System.out.println("before sort:" + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("after sort:" + Arrays.toString(numbers));

    }

    public static void bubbleSort(int arr[]) {
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int num = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = num;
                }
            }
        }
    }
}