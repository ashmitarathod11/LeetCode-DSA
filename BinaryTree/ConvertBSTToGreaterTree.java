
public class ConvertBSTToGreaterTree {

    static int sum = 0;

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode convertBST(TreeNode root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }

    static void reverseInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        reverseInorder(node.right);

        sum += node.val;
        node.val = sum;

        reverseInorder(node.left);
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

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        convertBST(root);

        System.out.println("Greater Tree (Inorder):");
        printInorder(root);
    }
}
