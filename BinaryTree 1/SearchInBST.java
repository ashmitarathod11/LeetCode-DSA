
public class SearchInBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        while (root != null && root.val != val) {

            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
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

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;

        TreeNode result = searchBST(root, val);

        if (result != null) {
            System.out.println("Subtree found:");
            printInorder(result);
        } else {
            System.out.println("Value not found");
        }
    }
}
