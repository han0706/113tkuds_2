import java.util.*;

class CacheEntry {
    int key; String value; int freq; long time;
    CacheEntry(int k, String v, int f, long t) { key = k; value = v; freq = f; time = t; }
}
public class MultiLevelCacheSystem {
    private int[] cap = {2,5,10};
    private PriorityQueue<CacheEntry>[] levels = new PriorityQueue[3];
    private Map<Integer,CacheEntry> map = new HashMap<>();
    private long ts = 0;
    public MultiLevelCacheSystem() {
        for (int i = 0; i < 3; i++) {
            int idx = i;
            levels[i] = new PriorityQueue<>((a,b)->a.freq==b.freq?Long.compare(a.time,b.time):a.freq-b.freq);
        }
    }
    public String get(int key) {
        if (!map.containsKey(key)) return null;
        CacheEntry e = map.get(key);
        e.freq++; e.time = ts++;
        rebalance();
        return e.value;
    }
    public void put(int key, String value) {
        if (map.containsKey(key)) {
            CacheEntry e = map.get(key);
            e.value = value; e.freq++; e.time = ts++;
            rebalance(); return;
        }
        CacheEntry e = new CacheEntry(key,value,1,ts++);
        map.put(key,e);
        levels[0].offer(e);
        rebalance();
    }
    private void rebalance() {
        for (int i = 0; i < 3; i++) {
            while (levels[i].size() > cap[i]) {
                CacheEntry evict = levels[i].poll();
                if (i < 2) levels[i+1].offer(evict);
            }
        }
    }
    public static void main(String[] args) {
        MultiLevelCacheSystem c = new MultiLevelCacheSystem();
        c.put(1,"A"); c.put(2,"B"); c.put(3,"C");
        c.get(1); c.get(1); c.get(2);
        c.put(4,"D"); c.put(5,"E"); c.put(6,"F");
    }
}
