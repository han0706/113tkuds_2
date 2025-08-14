public class AVLRotationExercise {
    static class Node {
        int val; int height; Node left,right;
        Node(int v){val=v;height=1;}
    }

    static int h(Node n){return n==null?0:n.height;}
    static void upd(Node n){n.height=Math.max(h(n.left),h(n.right))+1;}

    public static Node rotateRight(Node y){
        Node x=y.left; Node t2=x.right;
        x.right=y; y.left=t2;
        upd(y); upd(x);
        return x;
    }

    public static Node rotateLeft(Node x){
        Node y=x.right; Node t2=y.left;
        y.left=x; x.right=t2;
        upd(x); upd(y);
        return y;
    }

    public static Node rotateLeftRight(Node n){
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    public static Node rotateRightLeft(Node n){
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    static int bf(Node n){return h(n.left)-h(n.right);}    

    public static Node insert(Node n, int v){
        if(n==null) return new Node(v);
        if(v<n.val) n.left=insert(n.left,v); else if(v>n.val) n.right=insert(n.right,v); else return n;
        upd(n);
        int b=bf(n);
        if(b>1 && v<n.left.val) return rotateRight(n);
        if(b<-1 && v>n.right.val) return rotateLeft(n);
        if(b>1 && v>n.left.val) return rotateLeftRight(n);
        if(b<-1 && v<n.right.val) return rotateRightLeft(n);
        return n;
    }
}