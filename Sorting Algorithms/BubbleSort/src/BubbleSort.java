import java.util.Arrays;
/*
Bubble sort is an algorithm that compares the adjacent elements and swaps their positions if they are not in the
intended order. The order can be ascending or descending.

Complexity: O(n^2)
 */
public class BubbleSort {
    void bubbleSort(int array[]) {
        int size = array.length;

        for (int i=0; i<size-1; i++){
            boolean swapped = true;
            for (int j=0; j<size-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = false;
                }
            }
            if (swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] data = {-2,45,0,11,-9};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(data);
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }
}
