public class BSTValidationAndRepair {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode first, second, prev;

    public static boolean isValidBST(TreeNode root) {
        first = second = prev = null;
        return inorder(root);
    }

    private static boolean inorder(TreeNode node) {
        if (node == null) return true;
        if (!inorder(node.left)) return false;
        if (prev != null && node.val <= prev.val) return false;
        prev = node;
        return inorder(node.right);
    }

    public static void findSwapped(TreeNode root) {
        first = second = prev = null;
        findSwappedUtil(root);
    }

    private static void findSwappedUtil(TreeNode root) {
        if (root == null) return;
        findSwappedUtil(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        findSwappedUtil(root.right);
    }

    public static void recoverBST(TreeNode root) {
        findSwapped(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public static int minRemovalsToBST(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[1];
        maxBSTSubtree(root, count);
        int total = count[0];
        int size = treeSize(root);
        return size - total;
    }

    private static int maxBSTSubtree(TreeNode root, int[] maxSize) {
        if (root == null) return 0;
        int left = maxBSTSubtree(root.left, maxSize);
        int right = maxBSTSubtree(root.right, maxSize);
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            maxSize[0] = Math.max(maxSize[0], treeSize(root));
            return treeSize(root);
        }
        return Math.max(left, right);
    }

    private static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    private static int treeSize(TreeNode node) {
        if (node == null) return 0;
        return 1 + treeSize(node.left) + treeSize(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Is valid BST: " + isValidBST(root));
        recoverBST(root);
        System.out.println("Is valid BST after recovery: " + isValidBST(root));
        System.out.println("Min removals to BST: " + minRemovalsToBST(root));
    }
}
