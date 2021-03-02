public class Main {
    public static int[] insertionSort(int[] array) {
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
        return array;
    }
    public static void main(String[] args) {
        insertionSort(new int[] {21, 23, 19, 30, 11, 28 });
        insertionSort(new int[] {30, 28, 23, 21, 19, 11 });
    }
}
