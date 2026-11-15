
public class MinimumAbsoluteDifferenceBST {

    static int prev = -1;
    static int minDiff = Integer.MAX_VALUE;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        if (prev != -1) {
            minDiff = Math.min(minDiff, root.val - prev);
        }

        prev = root.val;

        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        inorder(root);

        System.out.println("Minimum Difference: " + minDiff);
    }
}

