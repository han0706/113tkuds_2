import java.util.*;

public class MeetingRoomScheduler {
    public static int minMeetingRooms(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] m : meetings) {
            if (!pq.isEmpty() && pq.peek() <= m[0]) pq.poll();
            pq.offer(m[1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
    }
}
