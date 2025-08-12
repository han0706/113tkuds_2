import java.util.*;

public class BasicMinHeapPractice {
    private List<Integer> heap = new ArrayList<>();
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }
    public int extractMin() {
        if (heap.isEmpty()) throw new NoSuchElementException();
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }
    public int getMin() {
        if (heap.isEmpty()) throw new NoSuchElementException();
        return heap.get(0);
    }
    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }
    private void heapifyUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(i) < heap.get(p)) {
                Collections.swap(heap, i, p);
                i = p;
            } else break;
        }
    }
    private void heapifyDown(int i) {
        while (true) {
            int l = 2 * i + 1, r = 2 * i + 2, s = i;
            if (l < heap.size() && heap.get(l) < heap.get(s)) s = l;
            if (r < heap.size() && heap.get(r) < heap.get(s)) s = r;
            if (s != i) {
                Collections.swap(heap, i, s);
                i = s;
            } else break;
        }
    }
    public static void main(String[] args) {
        BasicMinHeapPractice h = new BasicMinHeapPractice();
        int[] arr = {15,10,20,8,25,5};
        for (int x : arr) h.insert(x);
        while (!h.isEmpty()) System.out.print(h.extractMin() + " ");
    }
}
