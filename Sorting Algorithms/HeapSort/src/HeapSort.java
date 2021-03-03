/*
Heap Sort has O(nlog n) time complexities for all the cases ( best case, average case, and worst case).

Heap Sort Applications
Systems concerned with security and embedded systems such as Linux Kernel use Heap Sort because of the O(n log n) upper
bound on Heapsort's running time and constant O(1) upper bound on its auxiliary storage.

Although Heap Sort has O(n log n) time complexity even for the worst case, it doesn't have more applications ( compared
to other sorting algorithms like Quick Sort, Merge Sort ). However, its underlying data structure, heap, can be
efficiently used if we want to extract the smallest (or largest) from the list of items without the overhead of
keeping the remaining items in the sorted order. For e.g Priority Queues.
 */
public class HeapSort {

    public void sort(int arr[]) {
        int n = arr.length;

        for (int i=n/2-1; i>=0; i--) {
            heapify(arr, n, i);
        }

        for (int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    void heapify(int arr[], int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    void printArray(int[] array) {
        for (Integer i : array) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 9, 5, 6, 10};

        HeapSort h = new HeapSort();
        h.sort(arr);

        System.out.println("Sorted array is");
        h.printArray(arr);

    }
}
