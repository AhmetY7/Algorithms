/*
Binary Search is a searching algorithm for finding an element's position in a sorted array.

In this approach, the element is always searched in the middle of a portion of an array.

Binary search can be implemented only on a sorted list of items. If the elements are not sorted already,
we need to sort them first.

Complexity: O(log n)

Binary Search Applications
-In libraries of Java, .Net, C++ STL
-While debugging, the binary search is used to pinpoint the place where the error happens.
 */
public class BinarySearch {
    static int binarySearch(int array[], int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high -low) / 2;

            if (array[mid] == x)
                return mid;

            if (array[mid] < x)
                low = mid + 1;
            else
                high = mid + 1;
        }

        return -1;
    }

    static int recursiveBinarySearch(int array[], int x, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (array[mid] == x)
                return mid;

            if (array[mid] > x)
                return recursiveBinarySearch(array, x, low, mid-1);

            return recursiveBinarySearch(array, x, mid+1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 8, 9};
        int n = array.length;
        int x = 4;
        int result = binarySearch(array, x, 0, n-1);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
