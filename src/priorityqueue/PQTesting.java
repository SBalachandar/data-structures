package priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


public class PQTesting {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, 4, 5, 10, 5, 1, 123123, 2, 34};
        PQSort pqSort = new PQSort();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(pqSort);

        for (int x : arr) {
            priorityQueue.offer(x);
        }

        System.out.println(" priorityQueue " + priorityQueue);

        Iterator<Integer> it = priorityQueue.iterator();
        while (it.hasNext()) {
            System.out.print(" " + it.next());
        }

        System.out.println(" " + priorityQueue.poll());
        System.out.println(" " + priorityQueue.poll());

        System.out.println(" " + priorityQueue.poll());
        System.out.println(" " + priorityQueue.poll());

        System.out.println(" " + priorityQueue.poll());

        System.out.println(" " + priorityQueue.poll());
        System.out.println(" priorityQueue 1" + priorityQueue);


    }

    static class PQSort implements Comparator<Integer> {

        @Override
        public int compare(Integer one, Integer two) {
            // TODO Auto-generated method stub
            return two - one;
        }
    }

}
