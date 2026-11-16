
import java.util.*;

public class FindModeInBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    int prev;
    boolean hasPrev = false;
    int count = 0;
    int maxCount = 0;

    List<Integer> result = new ArrayList<>();

    void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        if (hasPrev && prev == root.val) {
            count++;
        } else {
            count = 1;
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        prev = root.val;
        hasPrev = true;

        inorder(root.right);
    }

    int[] findMode(TreeNode root) {

        inorder(root);

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        FindModeInBST solution = new FindModeInBST();

        int[] answer = solution.findMode(root);

        System.out.println("Modes: " + Arrays.toString(answer));
    }
}
