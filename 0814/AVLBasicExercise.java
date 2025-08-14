
public class AVLBasicExercise {
    static class Node {
        int val;
        int height;
        Node left, right;
        Node(int v){val=v;height=1;}
    }

    private Node root;

    public void insert(int val){
        root = insert(root, val);
    }

    public boolean search(int val){
        Node cur = root;
        while(cur!=null){
            if(val==cur.val) return true;
            if(val<cur.val) cur=cur.left; else cur=cur.right;
        }
        return false;
    }

    public int height(){
        return height(root);
    }

    public boolean isValidAVL(){
        return isBST(root, null, null) && isBalanced(root)!=-1;
    }

    private Node insert(Node n, int val){
        if(n==null) return new Node(val);
        if(val<n.val) n.left = insert(n.left, val);
        else if(val>n.val) n.right = insert(n.right, val);
        else return n;
        update(n);
        return rebalance(n);
    }

    private int height(Node n){return n==null?0:n.height;}

    private void update(Node n){
        n.height = Math.max(height(n.left), height(n.right)) + 1;
    }

    private int bf(Node n){
        return height(n.left)-height(n.right);
    }

    private Node rotateRight(Node y){
        Node x=y.left; Node T2=x.right;
        x.right=y; y.left=T2;
        update(y); update(x);
        return x;
    }

    private Node rotateLeft(Node x){
        Node y=x.right; Node T2=y.left;
        y.left=x; x.right=T2;
        update(x); update(y);
        return y;
    }

    private Node rebalance(Node n){
        int b=bf(n);
        if(b>1){
            if(bf(n.left)<0) n.left=rotateLeft(n.left);
            return rotateRight(n);
        }
        if(b<-1){
            if(bf(n.right)>0) n.right=rotateRight(n.right);
            return rotateLeft(n);
        }
        return n;
    }

    private boolean isBST(Node n, Integer low, Integer high){
        if(n==null) return true;
        if((low!=null && n.val<=low) || (high!=null && n.val>=high)) return false;
        return isBST(n.left, low, n.val) && isBST(n.right, n.val, high);
    }

    private int isBalanced(Node n){
        if(n==null) return 0;
        int lh=isBalanced(n.left); if(lh==-1) return -1;
        int rh=isBalanced(n.right); if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }
}