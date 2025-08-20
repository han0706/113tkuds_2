import java.io.*;
import java.util.*;

public class M11_HeapSortWithTie {
    static class P{
        int s, idx;
        P(int s,int idx){this.s=s;this.idx=idx;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        StringTokenizer st=new StringTokenizer(br.readLine());
        PriorityQueue<P> pq=new PriorityQueue<>((a,b)->{
            if(a.s!=b.s) return Integer.compare(a.s,b.s);
            return Integer.compare(a.idx,b.idx);
        });
        for(int i=0;i<n;i++) pq.offer(new P(Integer.parseInt(st.nextToken()), i));
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            if(sb.length()>0) sb.append(' ');
            sb.append(pq.poll().s);
        }
        System.out.print(sb.toString());
    }
}

/*
 * Time Complexity: O(n log n)
 * 說明：以堆排序思維使用最小堆逐一彈出，共進行 n 次堆操作，每次 O(log n)。
 */