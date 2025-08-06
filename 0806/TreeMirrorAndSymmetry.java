public class TreeMirrorAndSymmetry {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static TreeNode mirror(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static boolean areMirrors(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && areMirrors(a.left, b.right) && areMirrors(a.right, b.left);
    }

    public static boolean isSubtree(TreeNode root, TreeNode sub) {
        if (sub == null) return true;
        if (root == null) return false;
        if (isSameTree(root, sub)) return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    }

    private static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        TreeNode mirrorTree = mirror(new TreeNode(1));
        mirrorTree.left = new TreeNode(2);
        mirrorTree.right = new TreeNode(2);
        mirrorTree.left.left = new TreeNode(4);
        mirrorTree.left.right = new TreeNode(3);
        mirrorTree.right.left = new TreeNode(3);
        mirrorTree.right.right = new TreeNode(4);

        System.out.println("Is Symmetric: " + isSymmetric(root));
        TreeNode mirrored = mirror(root);
        System.out.print("Mirrored Inorder: ");
        inorder(mirrored);
        System.out.println();
        System.out.println("Are Mirrors: " + areMirrors(root, mirrorTree));
        System.out.println("Is Subtree: " + isSubtree(root, root.left));
    }
}
