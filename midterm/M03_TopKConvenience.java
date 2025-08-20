import java.io.*;
import java.util.*;

public class M03_TopKConvenience {
    static class Item{
        String name; int qty;
        Item(String n,int q){name=n;qty=q;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), K=Integer.parseInt(st.nextToken());
        PriorityQueue<Item> pq=new PriorityQueue<>( (a,b)->{
            if(a.qty!=b.qty) return Integer.compare(a.qty,b.qty);
            return a.name.compareTo(b.name);
        });
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            int qty=Integer.parseInt(st.nextToken());
            pq.offer(new Item(name,qty));
            if(pq.size()>K) pq.poll();
        }
        List<Item> res=new ArrayList<>();
        while(!pq.isEmpty()) res.add(pq.poll());
        Collections.sort(res,(a,b)->{
            if(b.qty!=a.qty) return Integer.compare(b.qty,a.qty);
            return a.name.compareTo(b.name);
        });
        StringBuilder sb=new StringBuilder();
        for(Item it:res){
            sb.append(it.name).append(' ').append(it.qty).append('\n');
        }
        System.out.print(sb.toString());
    }
}

/*
 * Time Complexity: O(n log K)
 * 說明：維護大小為 K 的最小堆，每筆資料進出堆成本 O(log K)；最後排序 K 筆為 O(K log K)。 
 */