/**
 * Abstract class provides a concrete implementation of the QuickSort algorithm. method can be
 * overriden by subclasses if required
 */
public abstract class AbstractSort {
  /**
   * This is the quickSort algorithm
   *
   * @param arr
   * @param low
   * @param high
   * @return
   */
  public static int[] quickSort(int[] arr, int low, int high) {

    if (arr == null || arr.length == 0) {
      System.out.println("There are no items on your list");
    }
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];

    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }
      while (arr[j] > pivot) {
        j--;
      }
      if (i <= j) {
        swap(arr, i, j);
        i++;
        j--;
      }
      if (low < j) {
        quickSort(arr, low, j);
      }
      if (high > i) {
        quickSort(arr, i, high);
      }
    }
    return arr;
  }

  public static void swap(int[] original, int x, int y) {
    int temp = original[x];
    original[x] = original[y];
    original[y] = temp;
  }
}
