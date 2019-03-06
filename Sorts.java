public class Sorts {
    public static void main(String[] args) {
        int[] testy = new int[] {12, -6, -432525, 45635467, 34, 1, 2, 0, 0, 1, 34, 7};
        for (int i = 0; i < testy.length; i++) {
            System.out.print(testy[i] + " ");
        }
        System.out.println();
        bubbleSort(testy);
        for (int i = 0; i < testy.length; i++) {
            System.out.print(testy[i] + " ");
        }
    }

    private Sorts() {}


    /**
     * Sorts any Comparable Object array, least to greatest.
     * Cuts off the array at each value, then places the smallest value
     * in the remaining array at the first spot in the remaining array
     * while swapping the original first value to the larger value's spot.
     *
     * @param toSort the array to be sorted
     * @param <T> the type the input array is composed of
     */
    public static <T extends Comparable<T>> void selectionSort(T[] toSort) {
        for (int i = 0; i < toSort.length - 1; i++) {                       // allows us to ignore each subsequent smallest value
            int smallestIndex = i;
            T smallest = toSort[i];
            for (int j = i + 1; j < toSort.length; j++) {                   // find the smallest one in this subsequence
                T now = toSort[j];
                if (now.compareTo(smallest) < 0) {                          // the first value is either first or the smallest so far
                    smallestIndex = j;
                    smallest = now;
                }
            }
            toSort[smallestIndex] = toSort[i];                              // perform the swap
            toSort[i] = smallest;
            /*for (int k = 0; k < toSort.length; k++) {
                System.out.print(toSort[k] + " ");
            }
            System.out.println();*/
        }
    }

    /**
     * Sorts any int array, least to greatest.
     * Cuts off the array at each value, then places the smallest value
     * in the remaining array at the first spot in the remaining array
     * while swapping the original first value to the larger value's spot.
     *
     * @param toSort the array to be sorted
     */
    public static void selectionSort(int[] toSort) {
      for (int i = 0; i < toSort.length - 1; i++) {                       // allows us to ignore each subsequent smallest value
          int smallestIndex = i;
          int smallest = toSort[i];
          for (int j = i + 1; j < toSort.length; j++) {                   // find the smallest one in this subsequence
              int now = toSort[j];
              if (now < smallest) {                                       // the first value is either first or the smallest so far
                  smallestIndex = j;
                  smallest = now;
              }
          }
          toSort[smallestIndex] = toSort[i];                              // perform the swap
          toSort[i] = smallest;
      }
    }

    /**
     * Sorts any int array, least to greatest.
     * Compares adjacent values and moves the larger one up, until
     * the end of the array, then sweeps through again, until no
     * swaps are made in a sweep.
     *
     * @param toSort the array to be sorted
     */
    public static void bubbleSort(int[] toSort) {
      int swaps = 1;
      while (swaps != 0) {                                                // terminate when it is ordered (no swaps were made on a sweep)
        swaps = 0;
        for (int i = 1; i < toSort.length; i++) {                         // go through the entire array
          int thisOne = toSort[i];                                        // save the current element for ease of access
          if (toSort[i] < toSort[i - 1]) {                                // swap
            toSort[i] = toSort[i - 1];
            toSort[i - 1] = thisOne;
            swaps++;                                                      // increments whenever a swap is made
          }
        }
      }
    }

 
    /**
     * Sorts any int array, least to greatest.
     * Sweeps through the array one element at a time, and if
     * the current element E is smaller than the last, shift elements
     * right until an element smaller than the current or index 0,
     * then assign the value E.
     *
     * @param toSort the array to be sorted
     */
    public static void insertionSort(int[] toSort) {
        for (int i = 1; i < toSort.length; i++) {                         // check each value only once      
            int j = i;
            int toInsert = toSort[j];                                     // save the value we are swapping back
            while (j > 0 && toSort[j - 1] > toInsert) {                   // occurs until the end or a smaller element
                toSort[j] = toSort[j - 1];                                // shift up
                j--;                                                      // move on to the next pair
            }
            toSort[j] = toInsert;
        }
    }
    /**
     * Sorts any Comparable Object array, least to greatest.
     * Sweeps through the array one element at a time, and if
     * the current element E is smaller than the last, shift elements
     * right until an element smaller than the current or index 0,
     * then assign the value E.
     *
     * @param toSort the array to be sorted
     * @param <T> the type the input array is composed of
     */
    public static <T extends Comparable<T>> void insertionSort(T[] toSort) {
        for (int i = 1; i < toSort.length; i++) {                         // check each value only once      
            int j = i;
            T toInsert = toSort[i];                                       // save the value we are swapping back
            while (j > 0 && (toSort[j - 1]).compareTo(toInsert) > 0) {    // occurs until the end or a smaller element
                toSort[j] = toSort[j - 1];                                // move up
                j--;                                                      // move on to the next pair
            }
            toSort[j] = toInsert;                                         // put the value in
        }
    }
}
