import java.util.Arrays;

/*
Radix sort is a sorting technique that sorts the elements by first grouping the individual digits of the same place value. Then, sort the elements according to their increasing/decreasing order.

Radix Sort Applications

DC3 algorithm (Kärkkäinen-Sanders-Burkhardt) while making a suffix array.
places where there are numbers in large ranges.
 */
public class RadixSort {
    void countSort(int array[], int size, int place) {
        int[] output = new int[size+1];

        int max = array[0];
        for (int i=0; i<size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max+1];

        for (int i=0; i<max; ++i) {
            count[i] = 0;
        }

        for (int i=0; i<size; i++) {
            count[(array[i] / place)%10]++;
        }

        for (int i=1; i<=max; i++) {
            count[i] += count[i-1];
        }

        for (int i=size-1; i>=0; i--) {
            output[count[(array[i]/place)%10]-1] = array[i];
            count[(array[i]/place) % 10]--;
        }

        if (size >= 0) System.arraycopy(output, 0, array, 0, size);
    }

    int getMax(int array[], int n) {
        int max = array[0];
        for (int i=1; i<n; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    void radixSort(int array[], int size) {
        int max = getMax(array, size);

        for (int place=1; max/place>0; place *=10)
            countSort(array, size, place);
    }

    public static void main(String[] args) {
        int[] data = {121, 432, 564, 23, 1, 45, 788};
        int size = data.length;
        RadixSort rs = new RadixSort();
        rs.radixSort(data, size);
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }
}
