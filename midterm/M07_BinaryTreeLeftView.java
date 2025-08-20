import java.io.*;
import java.util.*;

public class M07_BinaryTreeLeftView {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[] a=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) a[i]=Integer.parseInt(st.nextToken());
        StringBuilder out=new StringBuilder();
        List<Integer> ans=new ArrayList<>();
        if(n>0 && a[0]!=-1){
            ArrayDeque<Integer> q=new ArrayDeque<>();
            q.add(0);
            while(!q.isEmpty()){
                int sz=q.size();
                for(int i=0;i<sz;i++){
                    int idx=q.poll();
                    if(i==0) ans.add(a[idx]);
                    int l=2*idx+1, r=2*idx+2;
                    if(l<n && a[l]!=-1) q.add(l);
                    if(r<n && a[r]!=-1) q.add(r);
                }
            }
        }
        out.append("LeftView:");
        for(int i=0;i<ans.size();i++){
            out.append(i==0?" ":" ").append(ans.get(i));
        }
        System.out.print(out.toString());
    }
}