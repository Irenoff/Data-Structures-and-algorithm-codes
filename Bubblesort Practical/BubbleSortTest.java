public class BubbleSortTest {
    public static void main(String[] args) {
        // Array to be sorted
        int[] numbers = {8, 3, 1, 4, 5, 11, 7, 2, 17, 13};

        // Print the original array
        System.out.println("Original array:");
        printArray(numbers);

        // Create an object of BubbleSort class
        BubbleSort sorter = new BubbleSort();

        // Sort the array using bubbleSort() method
        sorter.bubbleSort(numbers);

        // Print the sorted array
        System.out.println("Sorted array after swapping:");
        printArray(numbers);
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}