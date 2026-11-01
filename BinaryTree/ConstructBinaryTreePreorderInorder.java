
import java.util.*;

public class ConstructBinaryTreePreorderInorder {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static Map<Integer, Integer> inorderMap;
    static int preorderIndex;

    public static TreeNode buildTree(
            int[] preorder, int[] inorder) {

        inorderMap = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(
            int[] preorder, int left, int right) {

        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int mid = inorderMap.get(rootValue);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.print("Reconstructed inorder: ");
        printInorder(root);

        System.out.println();
    }
}
