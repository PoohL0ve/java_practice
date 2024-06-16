import java.util.Arrays;



public class SimpleArrays {
    public static void main(String[] args) {
        int[] numbers = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8};
        int[] values = {56, 3, 34, 76, 12, 69, 7, 33, 11, 64, 45, 80};

        // System.out.println(Arrays.toString(insertionSort(numbers)));
        /* The java.util.Arrays library has a sort method
        *  which perform Dual-Pivot Quick Sort similar to an
        *  insertion sort method, that is quicker to use.
        *  Also, range sorting is possible */

        // Arrays.sort(values, 3, 9); // the last index is not included
        //System.out.println("Range Sort: " + Arrays.toString(values));

        /* For the binary search method to work, the array has to be
        *  sorted first. It returns a negative value if the number
        *  be found. */
       // int biSearch =  Arrays.binarySearch(numbers, 39);

        Arrays.sort(numbers);
        System.out.println("The value 32 is found at index: " +
                recursiveBinarySearch(numbers, 0, numbers.length - 1, 32));

        System.out.println("Using exponential search *****");
        Arrays.sort(values);
        System.out.println("The value 56 is at position: " + expoSearch(values, values.length, 56));


    }

    /**
     * The Insertion sort places items in their respective positions
     * according to the sorting criteria.
     * @param values an integer array
     * @return a sorted integer array
     */
    public static int[] insertionSort(int[] values) {
        int temp;

        for (int i = 1; i < values.length; i++){
            for (int j = i; j > 0; j--) {
                if (values[j] < values[j - 1]) {
                    temp = values[j]; // store the value at position j
                    // switch positions with the elements
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                }
            }
        }
        return values;
    }

    /**
     * A binary search method that looks for a value by continuously
     * cutting the array in half until the value is found.
     * @param numbers a sort array of integers
     * @param begin the starting position
     * @param end the last position in the array
     * @param key the value to be found; it's position
     * @return the position of the key value
     */
    public static int recursiveBinarySearch(int[] numbers, int begin, int end, int key) {
        System.out.println("Searching for the index of: " + key);
        if (begin < end) {  // if it's false -1 will be returned
            int middle = begin + (end - begin) / 2;
            if (key < numbers[middle]) {
                return recursiveBinarySearch(numbers, begin, middle, key);
            } else if (key > numbers[middle]) {
                return recursiveBinarySearch(numbers, middle + 1, end, key);
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * An exponential search method that uses 3 steps to find a value
     * and calculates the time complexity as O(log n) for the first
     * binary search.
     * @param numbers an array of integers
     * @param size the size of the array
     * @param key the value position to be found
     * @return the position of the key value
     */
    public static int expoSearch(int[] numbers, int size, int key) {
        // Step 1: check if the value is at the first position
        if (numbers[0] == key) {
            return 0;
        }

        // Step 2: Create the range for the binary search
        int index = 1;  // start with one because of the first step
        while (index < size && numbers[index] <= key) {
            index *= 2;  // to ensure that we are working with even numbers to divide
        }

        // Step 3: Perform the binary search
        return Arrays.binarySearch(numbers, (index / 2), Math.min(index, size), key);
    }
}
