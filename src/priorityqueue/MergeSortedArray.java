package priorityqueue;

public class MergeSortedArray {


    public static Integer[] merge(Integer[][] arrs) {
        Queue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                pq.offer(arrs[i][j]);
            }
        }

        Integer[] result = new Integer[pq.size()];
        int counter = 0;
        while (!pq.isEmpty()) {
            result[counter] = pq.poll();
            counter = counter + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {11, 21, 31, 41};
        Integer[] arr3 = {1111, 2111, 3111, 4111};
        Integer[] arr4 = {5, 6, 7, 8};
        Integer[][] arrs = {arr1, arr2, arr3, arr4};

        System.out.println(Arrays.toString(merge(arrs)));
    }

}
