package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class MedianFinder {

    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public static void main(String str[]) {
        MedianFinder meanFinder = new MedianFinder();
        System.out.println(meanFinder.getMedian());
        meanFinder.addNum(25);
        System.out.println(meanFinder.getMedian());
        meanFinder.addNum(50);
        System.out.println(meanFinder.getMedian());
        meanFinder.addNum(75);
        System.out.println(meanFinder.getMedian());
        meanFinder.addNum(100);
        System.out.println(meanFinder.getMedian());
    }

    private void rebalanceHeap() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        rebalanceHeap();
    }

    public double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}