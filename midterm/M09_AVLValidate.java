import java.io.*;
import java.util.*;

public class M09_AVLValidate {
    static int n; static int[] a;
    static boolean isBST(int idx, long low, long high){
        if(idx>=n || a[idx]==-1) return true;
        long v=a[idx];
        if(!(v>low && v<high)) return false;
        return isBST(2*idx+1, low, v) && isBST(2*idx+2, v, high);
    }
    static int height(int idx){
        if(idx>=n || a[idx]==-1) return 0;
        int lh=height(idx*2+1);
        if(lh<0) return -1;
        int rh=height(idx*2+2);
        if(rh<0) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine().trim());
        a=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) a[i]=Integer.parseInt(st.nextToken());
        if(!isBST(0, Long.MIN_VALUE, Long.MAX_VALUE)){ System.out.print("Invalid BST"); return; }
        if(height(0)<0){ System.out.print("Invalid AVL"); return; }
        System.out.print("Valid");
    }
}

/*
 * Time Complexity: O(n)
 * 說明：各檢查（BST 與 AVL 高度）皆為對每節點恰一次的遞迴走訪，總成本線性。
 */