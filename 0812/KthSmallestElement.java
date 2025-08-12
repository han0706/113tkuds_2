import java.util.*;

public class KthSmallestElement {
    public static int method1(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            maxHeap.offer(x);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.peek();
    }
    public static int method2(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : arr) minHeap.offer(x);
        for (int i = 1; i < k; i++) minHeap.poll();
        return minHeap.peek();
    }
    public static void main(String[] args) {
        System.out.println(method1(new int[]{7,10,4,3,20,15},3));
        System.out.println(method2(new int[]{7,10,4,3,20,15},3));
    }
}
