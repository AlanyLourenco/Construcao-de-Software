import java.util.Arrays;
import java.util.Random;

public class QuickSortIterative {
    public static void quicksortIterative(int[] arr) {
        int[] stack = new int[arr.length];

        int top = -1;
        stack[++top] = 0;
        stack[++top] = arr.length - 1;

        while (top >= 0) {
            int high = stack[top--];
            int low = stack[top--];

            int pivotIndex = partition(arr, low, high);

            if (pivotIndex - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivotIndex - 1;
            }

            if (pivotIndex + 1 < high) {
                stack[++top] = pivotIndex + 1;
                stack[++top] = high;
            }
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

            int[] arrIterative = arr.clone();
            long startTimeIterative = System.currentTimeMillis();
            quicksortIterative(arrIterative);
            long endTimeIterative = System.currentTimeMillis();
            System.out.println("Quicksort Iterative - Tempo de execução: " + (endTimeIterative - startTimeIterative) + "ms");

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
