import java.util.Arrays;

public class OptimizedInsertionSort {

    static Integer[] array = {21, 16, 13, 9, 6};
    static int outerIndex;
    static int temp;

    // Shifts elements to make space for insertion and returns the final position
    public static int shift(int startIndex) {
        temp = array[startIndex];
        int i = startIndex;
        
        // Shift elements to the right to find the correct position for temp
        for (; i > 0 && array[i - 1] > temp; i--) {
            array[i] = array[i - 1];
            System.out.println("i: " + outerIndex + "; j:" + (outerIndex - i + 1) + "; " + Arrays.deepToString(array));
        }
        return i;
    }

    // Inserts element at the endIndex in its correct position in sorted order
    public static void insert(int endIndex) {
        int position = shift(endIndex);
        array[position] = temp;
        System.out.println("After i: " + outerIndex + ": " + Arrays.deepToString(array));
    }

    // Sorts the entire array using optimized insertion sort
    public static void insertionSort() {
        for (outerIndex = 1; outerIndex < array.length; outerIndex++) {
            insert(outerIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println("Array before sorting: " + Arrays.deepToString(array));
        insertionSort();
        System.out.println("Array after sorting: " + Arrays.deepToString(array));
    }
}

