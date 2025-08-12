import java.util.*;

public class MovingAverageStream {
    private Queue<Integer> q = new LinkedList<>();
    private int size;
    private double sum = 0;
    private PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> high = new PriorityQueue<>();
    public MovingAverageStream(int size) { this.size = size; }
    public double next(int val) {
        q.offer(val);
        sum += val;
        if (low.isEmpty() || val <= low.peek()) low.offer(val); else high.offer(val);
        balance();
        if (q.size() > size) {
            int removed = q.poll();
            sum -= removed;
            if (!low.remove(removed)) high.remove(removed);
            balance();
        }
        return sum / q.size();
    }
    private void balance() {
        while (low.size() > high.size() + 1) high.offer(low.poll());
        while (high.size() > low.size()) low.offer(high.poll());
    }
    public double getMedian() { return size % 2 == 0 ? ((double)low.peek() + high.peek()) / 2 : low.peek(); }
    public int getMin() { return Collections.min(q); }
    public int getMax() { return Collections.max(q); }
    public static void main(String[] args) {
        MovingAverageStream m = new MovingAverageStream(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
        System.out.println(m.getMedian());
        System.out.println(m.getMin());
        System.out.println(m.getMax());
    }
}
