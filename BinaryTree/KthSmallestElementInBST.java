
public class KthSmallestElementInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count;
    static int answer;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        answer = 0;

        inorder(root, k);
        return answer;
    }

    private static boolean inorder(TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (inorder(node.left, k)) {
            return true;
        }

        count++;

        if (count == k) {
            answer = node.val;
            return true;
        }

        return inorder(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println("k = 1: " + kthSmallest(root, 1));
        System.out.println("k = 3: " + kthSmallest(root, 3));
    }
}
