import java.util.Arrays;

/*
Selection sort is an algorithm that selects the smallest element from an unsorted list in each iteration and places
that element at the beginning of the unsorted list.

Complexity = O(n2)
 */
public class SelectionSort {
    void selectionSort(int array[]) {
        int size = array.length;

        for (int step=0; step<size-1; step++) {
            int minIndex = step;
            for (int i= step+1; i<size; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }

            int temp = array[step];
            array[step] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {20, 12, 10, 15, 2};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(data);
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }
}
