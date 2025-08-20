import java.io.*;
import java.util.*;

public class M08_BSTRangedSum {
    static int n; static int[] a; static long L,R;
    static long dfs(int idx){
        if(idx>=n || a[idx]==-1) return 0;
        long val=a[idx];
        long sum=0;
        if(val>=L && val<=R) sum+=val;
        if(val>L) sum+=dfs(2*idx+1);
        if(val<R) sum+=dfs(2*idx+2);
        return sum;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine().trim());
        a=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) a[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        L=Long.parseLong(st.nextToken());
        R=Long.parseLong(st.nextToken());
        long s=dfs(0);
        System.out.print("Sum: " + s);
    }
}