import java.util.Arrays;

/*
Insertion sort works similarly as we sort cards in our hand in a card game.

We assume that the first card is already sorted then, we select an unsorted card. If the unsorted card is greater
than the card in hand, it is placed on the right otherwise, to the left. In the same way, other unsorted cards are
taken and put at their right place.

A similar approach is used by insertion sort.

Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration.


Complexity: O(n2)
 */
public class InsertionSort {
     void insertionSort(int[] array) {
        // iteration over the unsorted part
        for(int i=1; i<array.length; i++) {
            int elem = array[i];
            int j = i - 1;
            // finding suitable position
            while (j >= 0 && array[j] > elem) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = elem;
        }
    }
    public static void main(String[] args) {
         int[] data = {9, 5, 1, 4, 3};
         InsertionSort is = new InsertionSort();
         is.insertionSort(data);

         System.out.println("Sorted Array in Ascending Order:");
         System.out.println(Arrays.toString(data));
    }
}
