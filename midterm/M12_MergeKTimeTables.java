import java.io.*;
import java.util.*;

public class M12_MergeKTimeTables {
    static class Node{
        int t, li, pi;
        Node(int t,int li,int pi){this.t=t;this.li=li;this.pi=pi;}
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int K=Integer.parseInt(br.readLine().trim());
        List<int[]> lists=new ArrayList<>();
        for(int i=0;i<K;i++){
            int len=Integer.parseInt(br.readLine().trim());
            int[] arr=new int[len];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<len;j++) arr[j]=Integer.parseInt(st.nextToken());
            lists.add(arr);
        }
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Integer.compare(a.t,b.t));
        for(int i=0;i<K;i++) if(lists.get(i).length>0) pq.offer(new Node(lists.get(i)[0], i, 0));
        StringBuilder sb=new StringBuilder();
        boolean first=true;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            if(!first) sb.append(' '); first=false;
            sb.append(cur.t);
            int ni=cur.pi+1;
            int[] arr=lists.get(cur.li);
            if(ni<arr.length) pq.offer(new Node(arr[ni], cur.li, ni));
        }
        System.out.print(sb.toString());
    }
}