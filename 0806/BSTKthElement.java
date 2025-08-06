import java.util.*;

public class BSTKthElement {
    static class TreeNode {
        int val;
        int size;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.size = 1;
        }
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
            node.size = 1 + getSize(node.left) + getSize(node.right);
            return node;
        }

        public void delete(int val) {
            root = delete(root, val);
        }

        private TreeNode delete(TreeNode node, int val) {
            if (node == null) return null;
            if (val < node.val) node.left = delete(node.left, val);
            else if (val > node.val) node.right = delete(node.right, val);
            else {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                TreeNode successor = getMin(node.right);
                node.val = successor.val;
                node.right = delete(node.right, successor.val);
            }
            node.size = 1 + getSize(node.left) + getSize(node.right);
            return node;
        }

        private TreeNode getMin(TreeNode node) {
            while (node.left != null) node = node.left;
            return node;
        }

        private int getSize(TreeNode node) {
            return node == null ? 0 : node.size;
        }

        public int kthSmallest(int k) {
            return kthSmallest(root, k);
        }

        private int kthSmallest(TreeNode node, int k) {
            int leftSize = getSize(node.left);
            if (k == leftSize + 1) return node.val;
            if (k <= leftSize) return kthSmallest(node.left, k);
            return kthSmallest(node.right, k - leftSize - 1);
        }

        public int kthLargest(int k) {
            return kthLargest(root, k);
        }

        private int kthLargest(TreeNode node, int k) {
            int rightSize = getSize(node.right);
            if (k == rightSize + 1) return node.val;
            if (k <= rightSize) return kthLargest(node.right, k);
            return kthLargest(node.left, k - rightSize - 1);
        }

        public List<Integer> rangeKth(int k, int j) {
            List<Integer> result = new ArrayList<>();
            inOrder(root, result);
            return result.subList(k - 1, j);
        }

        private void inOrder(TreeNode node, List<Integer> result) {
            if (node == null) return;
            inOrder(node.left, result);
            result.add(node.val);
            inOrder(node.right, result);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {20, 8, 22, 4, 12, 10, 14};
        for (int v : values) tree.insert(v);

        System.out.println("3rd Smallest: " + tree.kthSmallest(3));
        System.out.println("2nd Largest: " + tree.kthLargest(2));
        System.out.println("From 2nd to 5th Smallest: " + tree.rangeKth(2, 5));
        tree.delete(10);
        System.out.println("After Deleting 10, 3rd Smallest: " + tree.kthSmallest(3));
    }
}
