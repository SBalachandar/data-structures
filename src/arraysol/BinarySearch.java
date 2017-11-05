package arraysol;

public class BinarySearch {

    private static boolean binarySearch(int[] arr, int starting, int end, int x) {
        if (arr == null || arr.length == 0) return false;

        if (starting <= end) {
            int middle = (starting + end) / 2;
            if (arr[middle] == x) return true;

            if (arr[middle] < x) {
                starting = middle + 1;
            } else {
                end = middle - 1;
            }
            return binarySearch(arr, starting, end, x);
        } else {
            return false;
        }
    }


    public static boolean binarySearchItertive(int[] arr, int x) {

        if (arr == null || arr.length == 0) return false;

        int starting = 0;
        int end = arr.length - 1;

        while (starting <= end) {

            int middle = (starting + end) / 2;
            if (arr[middle] == x) return true;

            if (arr[middle] < x) {
                starting = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] arr, int x) {
        return binarySearch(arr, 0, arr.length - 1, x);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("" + binarySearch(arr, 7));
        System.out.print("" + binarySearchItertive(arr, 71));


        // TODO Auto-generated method stub

    }

}
