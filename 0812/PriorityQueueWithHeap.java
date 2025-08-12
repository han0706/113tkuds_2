import java.util.*;

class Task {
    String name; int priority; long time;
    Task(String n, int p, long t) { name = n; priority = p; time = t; }
}
public class PriorityQueueWithHeap {
    private PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->a.priority==b.priority?Long.compare(a.time,b.time):b.priority-a.priority);
    private long timestamp = 0;
    public void addTask(String name, int priority) { pq.offer(new Task(name,priority,timestamp++)); }
    public String executeNext() { return pq.poll().name; }
    public String peek() { return pq.peek().name; }
    public void changePriority(String name, int newPriority) {
        List<Task> tmp = new ArrayList<>();
        while (!pq.isEmpty()) tmp.add(pq.poll());
        for (Task t : tmp) if (t.name.equals(name)) t.priority = newPriority;
        pq.addAll(tmp);
    }
    public static void main(String[] args) {
        PriorityQueueWithHeap q = new PriorityQueueWithHeap();
        q.addTask("備份",1); q.addTask("緊急修復",5); q.addTask("更新",3);
        System.out.println(q.executeNext());
        System.out.println(q.executeNext());
        System.out.println(q.executeNext());
    }
}
