public class AVLDeleteExercise {
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

    public void delete(int v){root=delete(root,v);}    
    private Node delete(Node n,int v){
        if(n==null) return null;
        if(v<n.val) n.left=delete(n.left,v);
        else if(v>n.val) n.right=delete(n.right,v);
        else{
            if(n.left==null || n.right==null){
                n = (n.left!=null)?n.left:n.right;
            }else{
                Node s=minNode(n.right);
                n.val=s.val;
                n.right=delete(n.right,s.val);
            }
        }
        if(n==null) return null;
        upd(n);
        return reb(n);
    }
    private Node minNode(Node n){while(n.left!=null) n=n.left; return n;}
    public boolean contains(int v){Node c=root; while(c!=null){if(v==c.val) return true; c=v<c.val?c.left:c.right;} return false;}
}