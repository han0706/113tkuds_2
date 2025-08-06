import java.util.*;

public class BSTRangeQuerySystem {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class BST {
        TreeNode root;

        public void insert(int val) {
            root = insert(root, val);
        }

        private TreeNode insert(TreeNode node, int val) {
            if (node == null) return new TreeNode(val);
            if (val < node.val) node.left = insert(node.left, val);
            else node.right = insert(node.right, val);
            return node;
        }

        public List<Integer> rangeQuery(int min, int max) {
            List<Integer> result = new ArrayList<>();
            rangeQuery(root, min, max, result);
            return result;
        }

        private void rangeQuery(TreeNode node, int min, int max, List<Integer> result) {
            if (node == null) return;
            if (node.val > min) rangeQuery(node.left, min, max, result);
            if (node.val >= min && node.val <= max) result.add(node.val);
            if (node.val < max) rangeQuery(node.right, min, max, result);
        }

        public int rangeCount(int min, int max) {
            return rangeCount(root, min, max);
        }

        private int rangeCount(TreeNode node, int min, int max) {
            if (node == null) return 0;
            if (node.val < min) return rangeCount(node.right, min, max);
            if (node.val > max) return rangeCount(node.left, min, max);
            return 1 + rangeCount(node.left, min, max) + rangeCount(node.right, min, max);
        }

        public int rangeSum(int min, int max) {
            return rangeSum(root, min, max);
        }

        private int rangeSum(TreeNode node, int min, int max) {
            if (node == null) return 0;
            if (node.val < min) return rangeSum(node.right, min, max);
            if (node.val > max) return rangeSum(node.left, min, max);
            return node.val + rangeSum(node.left, min, max) + rangeSum(node.right, min, max);
        }

        public int findClosest(int target) {
            return findClosest(root, target, root.val);
        }

        private int findClosest(TreeNode node, int target, int closest) {
            if (node == null) return closest;
            if (Math.abs(node.val - target) < Math.abs(closest - target)) closest = node.val;
            if (target < node.val) return findClosest(node.left, target, closest);
            else return findClosest(node.right, target, closest);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {10, 5, 1, 7, 15, 12, 20};
        for (int v : values) tree.insert(v);

        List<Integer> rangeList = tree.rangeQuery(5, 15);
        int count = tree.rangeCount(5, 15);
        int sum = tree.rangeSum(5, 15);
        int closest = tree.findClosest(13);

        System.out.println("Range Query [5,15]: " + rangeList);
        System.out.println("Range Count [5,15]: " + count);
        System.out.println("Range Sum [5,15]: " + sum);
        System.out.println("Closest to 13: " + closest);
    }
}
