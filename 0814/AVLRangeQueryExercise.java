import java.util.*;

public class AVLRangeQueryExercise {
    static class Node{int val,height;Node left,right;Node(int v){val=v;height=1;}}
    private Node root;
    private int h(Node n){return n==null?0:n.height;}
    private void upd(Node n){n.height=Math.max(h(n.left),h(n.right))+1;}
    private int bf(Node n){return h(n.left)-h(n.right);}    
    private Node rotR(Node y){Node x=y.left,t2=x.right; x.right=y; y.left=t2; upd(y); upd(x); return x;}
    private Node rotL(Node x){Node y=x.right,t2=y.left; y.left=x; x.right=t2; upd(x); upd(y); return y;}
    private Node reb(Node n){int b=bf(n); if(b>1){if(bf(n.left)<0) n.left=rotL(n.left); return rotR(n);} if(b<-1){if(bf(n.right)>0) n.right=rotR(n.right); return rotL(n);} return n;}

    public void insert(int v){root=insert(root,v);}    
    private Node insert(Node n,int v){if(n==null)return new Node(v); if(v<n.val) n.left=insert(n.left,v); else if(v>n.val) n.right=insert(n.right,v); else return n; upd(n); return reb(n);}    

    public java.util.List<Integer> rangeQuery(int min,int max){
        ArrayList<Integer> res=new ArrayList<>();
        range(root,min,max,res);
        return res;
    }
    private void range(Node n,int min,int max,java.util.List<Integer> res){
        if(n==null) return;
        if(n.val>min) range(n.left,min,max,res);
        if(n.val>=min && n.val<=max) res.add(n.val);
        if(n.val<max) range(n.right,min,max,res);
    }
}