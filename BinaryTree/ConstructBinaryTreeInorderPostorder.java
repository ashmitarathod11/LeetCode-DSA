
import java.util.*;

public class ConstructBinaryTreeInorderPostorder {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static Map<Integer, Integer> inorderMap;
    static int postorderIndex;

    public static TreeNode buildTree(
            int[] inorder, int[] postorder) {

        inorderMap = new HashMap<>();
        postorderIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(
            int[] postorder, int left, int right) {

        if (left > right) return null;

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        int mid = inorderMap.get(rootValue);

        root.right = build(postorder, mid + 1, right);
        root.left = build(postorder, left, mid - 1);

        return root;
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        System.out.print("Reconstructed inorder: ");
        printInorder(root);

        System.out.println();
    }
}
