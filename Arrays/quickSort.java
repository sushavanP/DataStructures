package dataStructures.Arrays;

import java.util.Arrays;

public class quickSort {
    public static void sort(int[] array){
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right){
        if(left >= right) return;

        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        sort(array, left, index - 1);
        sort(array, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right){
            while(array[left] < pivot)
                left++;

            while(array[right] > pivot)
                right--;

            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] array, int left, int right) {
        for(int i = 0; i < array.length; i++){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{8, 7, 2, 1, 0, 9, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
