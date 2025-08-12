import java.util.*;

public class SlidingWindowMedian {
    private PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> high = new PriorityQueue<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (low.isEmpty() || nums[i] <= low.peek()) low.offer(nums[i]); else high.offer(nums[i]);
            balance();
            if (i >= k) {
                if (!low.remove(nums[i - k])) high.remove(nums[i - k]);
                balance();
            }
            if (i >= k - 1) res[i - k + 1] = k % 2 == 0 ? ((double)low.peek() + high.peek()) / 2 : low.peek();
        }
        return res;
    }
    private void balance() {
        while (low.size() > high.size() + 1) high.offer(low.poll());
        while (high.size() > low.size()) low.offer(high.poll());
    }
    public static void main(String[] args) {
        SlidingWindowMedian s = new SlidingWindowMedian();
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
