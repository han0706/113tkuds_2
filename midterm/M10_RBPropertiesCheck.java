import java.io.*;
import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node{
        int val; char c;
        Node(int v,char c){this.val=v;this.c=c;}
    }
    static int n;
    static Node[] arr;
    static boolean isRed(Node nd){ return nd!=null && nd.val!=-1 && nd.c=='R'; }
    static boolean isBlack(Node nd){ return nd==null || nd.val==-1 || nd.c=='B'; }
    static class BHRes{
        boolean ok; int bh;
        BHRes(boolean o,int b){ok=o;bh=b;}
    }
    static BHRes blackHeight(int i){
        if(i>=n) return new BHRes(true,1);
        Node nd = arr[i];
        if(nd.val==-1) return new BHRes(true,1);
        BHRes L = blackHeight(2*i+1);
        if(!L.ok) return L;
        BHRes R = blackHeight(2*i+2);
        if(!R.ok) return R;
        if(L.bh!=R.bh) return new BHRes(false,0);
        int add = (nd.c=='B')?1:0;
        return new BHRes(true, L.bh + add);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine().trim());
        arr=new Node[n];
        String line; List<String> tokens=new ArrayList<>();
        while(tokens.size()<2*n && (line=br.readLine())!=null){
            line=line.trim(); if(line.isEmpty()) continue;
            StringTokenizer st=new StringTokenizer(line);
            while(st.hasMoreTokens()) tokens.add(st.nextToken());
        }
        for(int i=0, k=0;i<n;i++){
            int v=Integer.parseInt(tokens.get(k++));
            char c=tokens.get(k++).charAt(0);
            if(v==-1) c='B';
            arr[i]=new Node(v,c);
        }
        if(!isBlack(arr[0])){ System.out.print("RootNotBlack"); return; }
        for(int i=0;i<n;i++){
            Node nd=arr[i];
            if(nd.val==-1) continue;
            if(nd.c=='R'){
                int l=2*i+1, r=2*i+2;
                if(l<n && isRed(arr[l])){ System.out.print("RedRedViolation at index " + i); return; }
                if(r<n && isRed(arr[r])){ System.out.print("RedRedViolation at index " + i); return; }
            }
        }
        BHRes res=blackHeight(0);
        if(!res.ok){ System.out.print("BlackHeightMismatch"); return; }
        System.out.print("RB Valid");
    }
}