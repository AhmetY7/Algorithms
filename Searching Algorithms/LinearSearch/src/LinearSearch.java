/*
Linear search is the simplest searching algorithm that searches for an element in a list in sequential order. We start
at one end and check every element until the desired element is not found.

Linear Search Complexities
Time Complexity: O(n)

Space Complexity: O(1)

Linear Search Applications
For searching operations in smaller arrays (<100 items).
 */
public class LinearSearch {
    public static int linearSearch(int array[], int x) {
        int n = array.length;

        for (int i=0; i<n; i++) {
            if (array[i]==x)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {2, 4, 0, 1, 9};
        int x=1;

        int result = linearSearch(array, x);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
