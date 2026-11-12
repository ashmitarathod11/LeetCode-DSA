
import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private static boolean dfs(
        TreeNode node, int k, Set<Integer> set) {

        if (node == null) {
            return false;
        }

        int complement = k - node.val;

        if (set.contains(complement)) {
            return true;
        }

        set.add(node.val);

        return dfs(node.left, k, set) ||
               dfs(node.right, k, set);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        int k = 9;

        System.out.println(
            "Target found: " + findTarget(root, k)
        );
    }
}

