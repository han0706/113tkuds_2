
public class BSTConversionAndBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode head, prev;

    public static TreeNode bstToSortedDoublyList(TreeNode root) {
        head = prev = null;
        inorder(root);
        if (head != null) {
            head.left = prev;
            prev.right = head;
        }
        return head;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev == null) head = node;
        else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        inorder(node.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        if (left == -1) return -1;
        int right = checkHeight(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    public static void convertToGreaterSumTree(TreeNode root) {
        int[] sum = new int[1];
        convert(root, sum);
    }

    private static void convert(TreeNode node, int[] sum) {
        if (node == null) return;
        convert(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        convert(node.left, sum);
    }

    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        TreeNode bst = sortedArrayToBST(nums);
        inorderPrint(bst);
        System.out.println();

        TreeNode doublyList = bstToSortedDoublyList(bst);
        System.out.println("Doubly linked list head: " + doublyList.val);

        System.out.println("Is balanced: " + isBalanced(bst));

        convertToGreaterSumTree(bst);
        inorderPrint(bst);
        System.out.println();
    }
}
