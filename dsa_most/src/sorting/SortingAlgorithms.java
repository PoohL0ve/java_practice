package sorting;

/**
 * Sorting Algorithms are used to re-order a group
 * of elements in ascending or descending order. The
 * Big O notation is used to measure the performance
 * based on time complexities: Constant O(1),
 * Linear O(n), Logarithmic O(log n), and
 * Quadratic O(n exp 2).
 */
public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] numbers = {7, 5, 18, 11, 3, 24, 2};

        System.out.println("Bubble Sorted array: ");
        int[] bubbleSortNumbers = bubbleSort(numbers);
        display(bubbleSortNumbers);

        System.out.println("Selection Sorted array: ");
        int[] selectionSortNumbers = selectionSort(numbers);
        display(selectionSortNumbers);

        System.out.println("Merge Sorted array: ");
        display(mergeSort(numbers));

        System.out.println("Quick Sort array: ");
        display(quickSort(numbers, 0, numbers.length - 1));
    }

    /**
     * Displays the contents of the array on a single line
     * @param content an array of integers
     */
    public static void display(int [] content) {
        for (int item : content) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * The Bubble Sort Algorithm sorts values within an array
     * in ascending order, similar to bubbles in a jar,
     * where the lightest or smallest is pushed to the top. It
     * compares every element to each other to find the correct
     * position for the element.
     * @param values an array of integers
     * @return a Bubble sorted array
     */
    public static int[] bubbleSort(int[] values) {
        /* The performance of the sorting algorithm is
           O(n exp 2), which means the sorting time increases
           as the length of the array increases. It does not
           refer to the time it would take to search, just the
           length of the array.
         */
        int helper;
        int valSize = values.length;

        // the first loop goes through the entire array
        for (int i = 0; i < valSize - 1; i++) {
            for (int j = 0; j < valSize - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    helper = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = helper;
                }
            }
        }
        return values;
    }

    /**
     * The Selection Sort algorithm sorts the elements in an array
     * in ascending order by comparing the values to each other, with
     * fewer iterations occurring as the loop moves through the array.
     * @param values an array of integers
     * @return a sorted array of integers
     */
    public static int[] selectionSort(int[] values) {
        /*
        * Uses a O(n exp 2) performance and sorts
        * elements in place, using less storage space.
        * It is great to use with linked-lists, where addition
        * and removal of elements are necessary. Best and worst
        * case is O(n exp 2)*/

        int helper;
        int minValue;
        int valSize = values.length;

        for (int i = 0; i < valSize - 1; i++) {
            minValue = i;  // Used to compare which value is smaller and stores it
            for (int j = i + 1; j < valSize; j++) {
                if (values[minValue] > values[j]) {
                    minValue = j;
                }
            }
            helper = values[i];
            values[i] = values[minValue];
            values[minValue] = helper;
        }
        return values;
    }

    /**
     * The Merge Sort Algorithm, sorts an array in ascending order
     * by constantly splitting the array into sub-arrays, and using
     * recursion to pack the array in order.
     * @param values an array of integers
     * @return a sorted array
     */
    public static int[] mergeSort(int[] values) {
        /* Operates on the divide and conquer paradigm
        *  by dividing the array into multiple smaller
        *  arrays until each sub array has only 1 element in it.
        *  It operates on O(n log n) and is better on larger data sets.
        *  It is the sorting algorithm that Python uses.It uses more space */

        int arrLength = values.length;
        if (arrLength <= 1) {return values;}

        int middle = arrLength / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[arrLength - middle];

        int i = 0;  // index used for left array
        int j = 0;  // index used for right array

        for(; i < arrLength; i++) {
            if (i < middle) {
                leftArr[i] = values[i];
            } else {
                rightArr[j] = values[i];
                j++;
            }
        }
        // Use recursion to continuously split the array
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(values, leftArr, rightArr);
        return values;
    }
    public static void merge(int[] arr, int[] left, int[] right) {
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;

        // indices to merge the array
        int o = 0, l = 0, r = 0;
        while(l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                arr[o] = left[l];
                o++;
                l++;
            } else {
                arr[o] = right[r];
                o++;
                r++;
            }
        }
        while (l < leftSize) {
            arr[o] = left[l];
            o++;
            l++;
        }
        while (r < rightSize) {
            arr[o] = right[r];
            o++;
            r++;
        }
    }

    public static int[] quickSort(int[]arr, int start, int end) {
        /* It operates on the divide and conquer, through
        *  a method known as partition exchange sort.
        *  It is ine of the best internal sorting algorithms. Its
        *  worst performance is O(n exp 2), and the average is
        *  O(n log n). The pivot can be anywhere, which means
        *  Quick Sort has many variations and a space complexity of
        *  O(log n).*/

        if (end <= start) {
            return arr;
        }
        // values to the left of the pivot are smaller
        int pivot = partition(arr, start, end);  // point that is used to compare values
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);

        return arr;
    }

    public static int partition(int[] arr, int start, int end) {
        int helper;
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                helper = arr[i];
                arr[i] = arr[j];
                arr[j] = helper;
            }
        }
        i++;
        helper = arr[i];
        arr[i] = arr[end];
        arr[end] = helper;

        return i;  // the pivot
    }
}
