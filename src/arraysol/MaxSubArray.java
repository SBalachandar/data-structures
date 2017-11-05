package arraysol;

public class MaxSubArray {


    public static int maxSubArray(int[] arr) {

        int maxSofar = 0;
        int maxEndhere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndhere = maxEndhere + arr[i];
            if (maxEndhere < 0) {
                maxEndhere = 0;
            }
            if (maxSofar < maxEndhere) {
                maxSofar = maxEndhere;
            }
        }
        return maxSofar;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr1 = {2, 1, 11, 14, 41, 1, 100, 5, 4};

        System.out.println(maxSubArray(arr1));

    }

}
