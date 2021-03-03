import java.util.ArrayList;
import java.util.Collections;

/*
Bucket Sort is a sorting technique that sorts the elements by first dividing the elements into several groups called
buckets. The elements inside each bucket are sorted using any of the suitable sorting algorithms or recursively
calling the same algorithm.

Several buckets are created. Each bucket is filled with a specific range of elements. The elements inside the bucket
are sorted using any other algorithm. Finally, the elements of the bucket are gathered to get the sorted array.

The process of bucket sort can be understood as a scatter-gather approach. The elements are first scattered into
buckets then the elements of buckets are sorted. Finally, the elements are gathered in order.

Average Case Complexity: O(n)

Bucket Sort Applications

-input is uniformly distributed over a range.
-there are floating point values
 */
public class BucketSort {
    public void bucketSort(float[] arr, int n) {
        if (n<=0)
            return;

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];

        for (int i=0; i<n; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }

        for (int i=0; i<n; i++) {
            Collections.sort((bucket[i]));
        }

        int index = 0;
        for (int i=0; i<n; i++) {
            for (int j=0, size=bucket[i].size(); j<size; j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        BucketSort b = new BucketSort();

        float[] arr = {0.42F, 0.32F, 0.33F, 0.52F, 0.37F, 0.47F, 0.51F};
        b.bucketSort(arr, 7);

        for (float i:arr)
            System.out.println(i + " ");
    }
}
