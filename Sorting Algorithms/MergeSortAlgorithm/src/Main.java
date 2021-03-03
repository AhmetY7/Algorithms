/*
Merge Sort is one of the most popular sorting algorithms that is based on the principle of Divide and Conquer Algorithm.

A problem is divided into multiple sub-problems. Each sub-problem is solved individually. Finally, sub-problems
are combined to form the final solution.

Complexity: O(n*log n)

Merge Sort Applications
-Inversion count problem
-External sorting
-E-commerce applications
 */
public class Main {
    public static void  mergeSort(int[] array, int leftIncl, int rightExcl) {
        // the base condition
        if (rightExcl <= leftIncl +1) {
            return;
        }
        // divide: calculating the middle element
        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        mergeSort(array, leftIncl, middle); // conquer: sort the left subarray
        mergeSort(array, middle, rightExcl); // conquer: sort the right subarray

        // combine : merge sorted subarrays into sorted one
        merge(array, leftIncl, middle, rightExcl);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int l = left; // index for the left subarray
        int m = middle; // index for the right subarray
        int k = 0; // index for the temp subarray

        int[] temp = new int[right - left]; // temporary array for merging

        while (l < middle && m < right) {
            if (array[l] <= array[m]) {
                temp[k] = array[l];
                l++;
            } else {
                temp[k] = array[m];
                m++;
            }
            k++;
        }

        // insert all the remaining elements of the left subarray in the array
        for(;l < middle; l++, k++) {
            temp[k] = array[l];
        }

        // insert all the remaining elements of the right subarray in the array
        for(;m < right; m++, k++) {
            temp[k] = array[m];
        }

        //Copying elements from temp to array
        System.arraycopy(temp, 0, array, left, temp.length);
    }
    public static void main(String[] args) {
        int[] array1 = {30, 21, 23, 19, 28, 11, 23};
        mergeSort(array1, 0, array1.length);

        int[] array2 = {30, 20, 10, 10, 20, 10};
        mergeSort(array2, 0, array2.length);
    }
}
