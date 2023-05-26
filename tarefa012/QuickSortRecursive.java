import java.util.Arrays;
import java.util.Random;

public class QuickSortRecursive {
    public static void quicksortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksortRecursive(arr, low, pivotIndex - 1);
            quicksortRecursive(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            System.out.println("Array Size: " + size);

            int[] arrRecursive = arr.clone();
            long startTimeRecursive = System.currentTimeMillis();
            quicksortRecursive(arrRecursive, 0, arrRecursive.length - 1);
            long endTimeRecursive = System.currentTimeMillis();
            System.out.println("Quicksort Recursive - Tempo de execução: " + (endTimeRecursive - startTimeRecursive) + "ms");

            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }
}
