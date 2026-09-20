import java.util.HashMap;

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        // First pass
        Node current = head;

        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Second pass
        current = head;

        while (current != null) {

            Node copy = map.get(current);

            copy.next = map.get(current.next);
            copy.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }

    public static void printList(Node head) {

        while (head != null) {

            int randomValue;

            if (head.random != null) {
                randomValue = head.random.val;
            } else {
                randomValue = -1;
            }

            System.out.println(
                "Node: " + head.val +
                ", Random: " + randomValue
            );

            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        Node copiedHead = copyRandomList(node1);

        System.out.println("Copied List:");

        printList(copiedHead);
    }
}