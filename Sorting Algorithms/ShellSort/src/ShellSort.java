/*
Shell sort is an algorithm that first sorts the elements far apart from each other and successively reduces the
interval between the elements to be sorted. It is a generalized version of insertion sort.

In shell sort, elements at a specific interval are sorted. The interval between the elements is gradually decreased
based on the sequence used. The performance of the shell sort depends on the type of sequence used for a given input array.

Shell Sort Applications

-calling a stack is overhead. uClibc library uses this sort.
-recursion exceeds a limit. bzip2 compressor uses it.
-Insertion sort does not perform well when the close elements are far apart. Shell sort helps in reducing the distance
between the close elements. Thus, there will be less number of swappings to be performed.

Worst Case Complexity: less than or equal to O(n2)
Average Case Complexity: O(n*log n)
The complexity depends on the interval chosen. The above complexities differ for different increment sequences chosen. Best increment sequence is unknown.
 */
public class ShellSort {

}
