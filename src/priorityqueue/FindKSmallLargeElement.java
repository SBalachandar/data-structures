package priorityqueue;

public class FindKSmallLargeElement {

    public static int findKSmall(int arr[], int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int len = pq.size();

        if (len < k) {
            return Integer.MIN_VALUE;
        } else {
            int i = 0;
            while (!pq.isEmpty()) {
                int e = pq.poll();
                if (k == i) return e;
                i++;
            }
        }

        return Integer.MIN_VALUE;
    }


    public static int findKLargest(int arr[], int k) {
        //Queue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }

        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int len = pq.size();

        if (len < k) {
            return Integer.MIN_VALUE;
        } else {
            int i = 0;
            while (!pq.isEmpty()) {
                int e = pq.poll();
                if (k == i) return e;
                i++;
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = {1, 2, 10, 2342, 234, 12, 3, 41, 11};
        System.out.println(findKSmall(arr, 3));
        System.out.println(findKLargest(arr, 1));


    }

}
