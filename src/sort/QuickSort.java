package sort;

public class QuickSort {

    public static void main(String[] args) {
        HoarePartition hoare = new HoarePartition();
        LomutoPartition lomuto = new LomutoPartition();

        int[] arr = {10, 1, 5, 2, 8, 4, -3, 15, 10, 0, -1};
        int n = arr.length;

        hoare.quickSort(arr, 0, n - 1);
        hoare.printArray(arr);

        lomuto.quickSort(arr, 0, n - 1);
        lomuto.printArray(arr);
    }
}
