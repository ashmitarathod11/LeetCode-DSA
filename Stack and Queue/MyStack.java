import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.add(x);

        int size = queue.size();

        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top());

        System.out.println("Pop: " + stack.pop());

        System.out.println("Top after pop: " + stack.top());

        System.out.println("Is Empty: " + stack.empty());
    }
}