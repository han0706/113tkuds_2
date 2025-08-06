import java.util.*;

public class MultiWayTreeAndDecisionTree {
    static class MultiWayNode {
        int val;
        List<MultiWayNode> children;
        MultiWayNode(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    public static void dfs(MultiWayNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        for (MultiWayNode child : node.children) dfs(child, result);
    }

    public static void bfs(MultiWayNode root, List<Integer> result) {
        if (root == null) return;
        Queue<MultiWayNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            MultiWayNode node = queue.poll();
            result.add(node.val);
            for (MultiWayNode child : node.children) queue.offer(child);
        }
    }

    static class DecisionNode {
        String question;
        DecisionNode yesBranch, noBranch;
        String guess;
        DecisionNode(String question) { this.question = question; }
        DecisionNode(String question, String guess) {
            this.question = question;
            this.guess = guess;
        }
    }

    public static String guessNumber(DecisionNode node, Scanner sc) {
        if (node == null) return null;
        if (node.guess != null) return node.guess;
        System.out.println(node.question + " (y/n)");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("y")) return guessNumber(node.yesBranch, sc);
        else return guessNumber(node.noBranch, sc);
    }

    public static int getHeight(MultiWayNode node) {
        if (node == null) return 0;
        int maxHeight = 0;
        for (MultiWayNode child : node.children) maxHeight = Math.max(maxHeight, getHeight(child));
        return maxHeight + 1;
    }

    public static int getDegree(MultiWayNode node) {
        if (node == null) return 0;
        int degree = node.children.size();
        for (MultiWayNode child : node.children) degree = Math.max(degree, getDegree(child));
        return degree;
    }

    public static void main(String[] args) {
        MultiWayNode root = new MultiWayNode(1);
        MultiWayNode c1 = new MultiWayNode(2);
        MultiWayNode c2 = new MultiWayNode(3);
        MultiWayNode c3 = new MultiWayNode(4);
        root.children.add(c1);
        root.children.add(c2);
        c1.children.add(c3);

        List<Integer> dfsResult = new ArrayList<>();
        dfs(root, dfsResult);
        System.out.println("DFS: " + dfsResult);

        List<Integer> bfsResult = new ArrayList<>();
        bfs(root, bfsResult);
        System.out.println("BFS: " + bfsResult);

        DecisionNode rootDec = new DecisionNode("Is it greater than 50?");
        rootDec.yesBranch = new DecisionNode("Is it greater than 75?");
        rootDec.noBranch = new DecisionNode("Is it less than 25?");
        rootDec.yesBranch.yesBranch = new DecisionNode(null, "Guess: 90");
        rootDec.yesBranch.noBranch = new DecisionNode(null, "Guess: 60");
        rootDec.noBranch.yesBranch = new DecisionNode(null, "Guess: 10");
        rootDec.noBranch.noBranch = new DecisionNode(null, "Guess: 30");

        Scanner sc = new Scanner(System.in);
        String guess = guessNumber(rootDec, sc);
        System.out.println(guess);

        System.out.println("MultiWay Tree Height: " + getHeight(root));
        System.out.println("MultiWay Tree Degree: " + getDegree(root));
    }
}
