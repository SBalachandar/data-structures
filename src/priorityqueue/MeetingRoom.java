package priorityqueue;


import static java.util.Comparator.*;

class Interval {
    private final int startTime;
    private final int endTime;

    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" starttime : " + startTime);
        sb.append(" endTime : " + endTime);
        return sb.toString();
    }
}

public class MeetingRoom {

    static final List<Interval> intervals = Arrays.asList(new Interval(930, 1000), new Interval(945, 1030),
            new Interval(1030, 1100), new Interval(910, 1200));

    static final Function<Interval, Integer> sortByStartTime = interval -> interval.getStartTime();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MeetingRoom().size(intervals));
    }

    private List<Interval> sortIntervalsByStartTime(List<Interval> intervals) {
        return intervals.stream().sorted(comparing(sortByStartTime)).collect(Collectors.toList());
    }

    public int size(List<Interval> intervals) {
        Queue<Integer> pq = new PriorityQueue<>();
        List<Interval> sIntervals = sortIntervalsByStartTime(intervals);
        if (sIntervals.isEmpty()) {
            return 0;
        }

        int endTime = sIntervals.get(0).getEndTime();
        pq.offer(endTime);

        for (int i = 1; i < sIntervals.size(); i++) {
            Interval interval = sIntervals.get(i);
            if (interval.getStartTime() >= pq.peek()) {
                pq.poll();
                pq.offer(interval.getEndTime());
            } else {
                pq.offer(interval.getEndTime());
            }
        }

        return pq.size();
    }

}
