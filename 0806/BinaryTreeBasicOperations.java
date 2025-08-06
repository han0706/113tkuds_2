import java.util.*;

public class BinaryTreeBasicOperations {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    public static int getCount(TreeNode root) {
        if (root == null) return 0;
        return 1 + getCount(root.left) + getCount(root.right);
    }

    public static int getMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(getMax(root.left), getMax(root.right)));
    }

    public static int getMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(getMin(root.left), getMin(root.right)));
    }

    public static int getMaxWidth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return maxWidth;
    }

    public static boolean isComplete(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) foundNull = true;
            else {
                if (foundNull) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        int sum = getSum(root);
        int count = getCount(root);
        double avg = (double) sum / count;
        int max = getMax(root);
        int min = getMin(root);
        int width = getMaxWidth(root);
        boolean complete = isComplete(root);

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Max Width: " + width);
        System.out.println("Is Complete: " + complete);
    }
}
