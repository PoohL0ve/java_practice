import java.util.Arrays;



public class SimpleArrays {
    public static void main(String[] args) {
        int[] numbers = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8};
        int[] values = {56, 3, 34, 76, 12, 69, 7, 33, 11, 64, 45, 80};

        System.out.println(Arrays.toString(insertionSort(numbers)));
        /* The java.util.Arrays library has a sort method
        *  which perform Dual-Pivot Quick Sort similar to an
        *  insertion sort method, that is quicker to use.
        *  Also, range sorting is possible */
        Arrays.sort(values, 3, 9); // the last index is not included
        System.out.println("Range Sort: " + Arrays.toString(values));

        /* For the binary search method to work, the array has to be
        *  sorted first. It returns a negative value if the number
        *  be found. */
       int biSearch =  Arrays.binarySearch(numbers, 39);
        System.out.println("Binary Search on numbers: " + biSearch);

        String classList[] = {"John", "Jean","James"};

        String graduatesList[] = {"John", "Jean", "James"};

        if(Arrays.equals(classList, graduatesList)) {

            System.out.println("All the students in this class are graduating");

        } else {

            System.out.println("Some of the students are not graduating.");

        }
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
}
