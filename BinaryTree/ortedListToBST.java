
public class SortedListToBST {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static ListNode current;

    public static TreeNode sortedListToBST(ListNode head) {

        current = head;

        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return buildBST(0, size - 1);
    }

    private static TreeNode buildBST(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode leftChild = buildBST(left, mid - 1);

        TreeNode root = new TreeNode(current.val);

        root.left = leftChild;

        current = current.next;

        root.right = buildBST(mid + 1, right);

        return root;
    }

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        // Create sorted linked list
        ListNode head = new ListNode(-10);

        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        // Convert linked list into BST
        TreeNode root = sortedListToBST(head);

        System.out.print("BST Inorder: ");
        inorder(root);

        System.out.println();

        System.out.println("Root value: " + root.val);
    }
}
