import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int preIndex;
    static Map<Integer, Integer> inMap;

    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        preIndex = 0;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildPreIn(preorder, 0, inorder.length - 1);
    }

    private static TreeNode buildPreIn(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (inStart == inEnd) return root;
        int inIndex = inMap.get(root.val);
        root.left = buildPreIn(preorder, inStart, inIndex - 1);
        root.right = buildPreIn(preorder, inIndex + 1, inEnd);
        return root;
    }

    static int postIndex;
    static Map<Integer, Integer> inMapPost;

    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        postIndex = postorder.length - 1;
        inMapPost = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMapPost.put(inorder[i], i);
        return buildPostIn(postorder, 0, inorder.length - 1);
    }

    private static TreeNode buildPostIn(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postIndex--]);
        if (inStart == inEnd) return root;
        int inIndex = inMapPost.get(root.val);
        root.right = buildPostIn(postorder, inIndex + 1, inEnd);
        root.left = buildPostIn(postorder, inStart, inIndex - 1);
        return root;
    }

    public static TreeNode buildCompleteTreeLevelOrder(int[] levelorder) {
        if (levelorder.length == 0) return null;
        TreeNode root = new TreeNode(levelorder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < levelorder.length) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(levelorder[i++]);
            queue.offer(node.left);
            if (i < levelorder.length) {
                node.right = new TreeNode(levelorder[i++]);
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static boolean verifyTreesEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return verifyTreesEqual(a.left, b.left) && verifyTreesEqual(a.right, b.right);
    }

    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root1 = buildTreePreIn(preorder, inorder);
        inorderPrint(root1);
        System.out.println();

        int[] postorder = {9,15,7,20,3};
        TreeNode root2 = buildTreePostIn(postorder, inorder);
        inorderPrint(root2);
        System.out.println();

        int[] levelorder = {1,2,3,4,5,6,7};
        TreeNode root3 = buildCompleteTreeLevelOrder(levelorder);
        inorderPrint(root3);
        System.out.println();

        System.out.println("Trees equal: " + verifyTreesEqual(root1, root2));
    }
}
