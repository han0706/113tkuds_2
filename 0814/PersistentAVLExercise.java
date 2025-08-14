import java.util.*;

public class PersistentAVLExercise {
    static final class Node {
        final int val, height;
        final Node left, right;
        Node(int v, Node l, Node r) { val = v; left = l; right = r; height = Math.max(h(l), h(r)) + 1; }
    }

    static int h(Node n) { return n == null ? 0 : n.height; }
    static int bf(Node n) { return h(n.left) - h(n.right); }

    static Node rotR(Node y) {
        Node x = y.left, t2 = x.right;
        Node ny = new Node(y.val, t2, y.right);
        return new Node(x.val, x.left, ny);
    }

    static Node rotL(Node x) {
        Node y = x.right, t2 = y.left;
        Node nx = new Node(x.val, x.left, t2);
        return new Node(y.val, nx, y.right);
    }

    static Node reb(Node n) {
        int b = bf(n);
        if (b > 1) {
            if (bf(n.left) < 0) n = new Node(n.val, rotL(n.left), n.right);
            return rotR(n);
        }
        if (b < -1) {
            if (bf(n.right) > 0) n = new Node(n.val, n.left, rotR(n.right));
            return rotL(n);
        }
        return n;
    }

    static Node insert(Node n, int v) {
        if (n == null) return new Node(v, null, null);
        if (v < n.val) n = new Node(n.val, insert(n.left, v), n.right);
        else if (v > n.val) n = new Node(n.val, n.left, insert(n.right, v));
        else return n;
        return reb(n);
    }

    static boolean contains(Node n, int v) {
        while (n != null) {
            if (v == n.val) return true;
            n = v < n.val ? n.left : n.right;
        }
        return false;
    }

    static int height(Node n) { return h(n); }

    public static class VersionedAVL {
        private final ArrayList<Node> versions = new ArrayList<>();
        public VersionedAVL() { versions.add(null); }
        public int currentVersion() { return versions.size() - 1; }
        public int insertNewVersion(int v) { Node newRoot = insert(versions.get(currentVersion()), v); versions.add(newRoot); return currentVersion(); }
        public boolean containsAt(int version, int v) { return contains(versions.get(version), v); }
        public int heightAt(int version) { return height(versions.get(version)); }
    }
}