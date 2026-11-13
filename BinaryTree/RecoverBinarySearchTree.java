
public class RecoverBinarySearchTree {

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void recoverTree(TreeNode root) {

        first = null;
        second = null;
        prev = null;

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    static void inorder(TreeNode node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev != null && prev.val > node.val) {

            if (first == null) {
                first = prev;
            }

            second = node;
        }

        prev = node;

        inorder(node.right);
    }

    static void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);

        System.out.print(root.val + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(2);

        System.out.println("Before Recovery:");
        printInorder(root);

        recoverTree(root);

        System.out.println("\nAfter Recovery:");
        printInorder(root);
    }
}
