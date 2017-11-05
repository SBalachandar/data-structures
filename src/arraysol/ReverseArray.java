package arraysol;

public class ReverseArray {

    public static int[] reverse(int[] arr, int start, int end) {
        if (arr == null || arr.length <= 1) return arr;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start = start + 1;
        end = end - 1;
        int middle = (start + end) / 2;

        if (start <= middle) {
            reverse(arr, start, end);
        }

        return arr;
    }

    public static void printArray(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        printArray(reverse(arr, 0, arr.length - 1));
    }

}
