import java.util.*;

class Element {
    int val, arrIdx, eleIdx;
    Element(int v, int a, int e) { val = v; arrIdx = a; eleIdx = e; }
}
public class MergeKSortedArrays {
    public static List<Integer> merge(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(e->e.val));
        for (int i = 0; i < arrays.length; i++) if (arrays[i].length > 0) pq.offer(new Element(arrays[i][0], i, 0));
        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            res.add(cur.val);
            if (cur.eleIdx + 1 < arrays[cur.arrIdx].length)
                pq.offer(new Element(arrays[cur.arrIdx][cur.eleIdx + 1], cur.arrIdx, cur.eleIdx + 1));
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,4,5},{1,3,4},{2,6}};
        System.out.println(merge(arr));
    }
}
