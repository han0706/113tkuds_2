import java.util.*;

public class AVLLeaderboardSystem {
    static class Node{
        int score; int playerId; int height; int size; Node left,right;
        Node(int s,int id){score=s;playerId=id;height=1;size=1;}
    }

    private Node root;
    private final Map<Integer,Integer> idToScore=new HashMap<>();

    private int h(Node n){return n==null?0:n.height;}
    private int sz(Node n){return n==null?0:n.size;}
    private void upd(Node n){n.height=Math.max(h(n.left),h(n.right))+1; n.size=sz(n.left)+sz(n.right)+1;}
    private int cmp(int s1,int id1,int s2,int id2){
        if(s1!=s2) return s2-s1;
        return Integer.compare(id1,id2);
    }

    private int bf(Node n){return h(n.left)-h(n.right);}    
    private Node rotR(Node y){Node x=y.left,t2=x.right; x.right=y; y.left=t2; upd(y); upd(x); return x;}
    private Node rotL(Node x){Node y=x.right,t2=y.left; y.left=x; x.right=t2; upd(x); upd(y); return y;}
    private Node reb(Node n){int b=bf(n); if(b>1){if(bf(n.left)<0) n.left=rotL(n.left); return rotR(n);} if(b<-1){if(bf(n.right)>0) n.right=rotR(n.right); return rotL(n);} return n;}

    private Node insert(Node n,int s,int id){
        if(n==null) return new Node(s,id);
        if(cmp(s,id,n.score,n.playerId)<0) n.left=insert(n.left,s,id);
        else if(cmp(s,id,n.score,n.playerId)>0) n.right=insert(n.right,s,id);
        else return n;
        upd(n); return reb(n);
    }

    private Node delete(Node n,int s,int id){
        if(n==null) return null;
        int c=cmp(s,id,n.score,n.playerId);
        if(c<0) n.left=delete(n.left,s,id);
        else if(c>0) n.right=delete(n.right,s,id);
        else{
            if(n.left==null||n.right==null){n = (n.left!=null)?n.left:n.right;}
            else{
                Node t = minNode(n.right);
                n.score=t.score; n.playerId=t.playerId;
                n.right=delete(n.right,t.score,t.playerId);
            }
        }
        if(n==null) return null;
        upd(n); return reb(n);
    }

    private Node minNode(Node n){while(n.left!=null) n=n.left; return n;}

    public void addPlayerScore(int playerId,int score){
        if(idToScore.containsKey(playerId)) return;
        root=insert(root,score,playerId);
        idToScore.put(playerId,score);
    }

    public void updatePlayerScore(int playerId,int newScore){
        Integer old=idToScore.get(playerId);
        if(old!=null){root=delete(root,old,playerId);}
        root=insert(root,newScore,playerId); idToScore.put(playerId,newScore);
    }

    public int getPlayerRank(int playerId){
        Integer s=idToScore.get(playerId); if(s==null) return -1;
        return rank(root,s,playerId);
    }

    private int rank(Node n,int s,int id){
        int r=1; Node cur=n;
        while(cur!=null){
            int c=cmp(s,id,cur.score,cur.playerId);
            if(c<0){cur=cur.left;}
            else if(c>0){r+=sz(cur.left)+1; cur=cur.right;}
            else{r+=sz(cur.left); break;}
        }
        return r;
    }

    public java.util.List<int[]> topK(int k){
        ArrayList<int[]> res=new ArrayList<>();
        reverseInorder(root,res,k);
        return res;
    }
    private void reverseInorder(Node n, java.util.List<int[]> res, int k){
        if(n==null||res.size()>=k) return;
        reverseInorder(n.right,res,k);
        if(res.size()<k) res.add(new int[]{n.playerId,n.score});
        reverseInorder(n.left,res,k);
    }
}