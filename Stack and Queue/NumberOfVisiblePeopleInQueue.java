
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NumberOfVisiblePeopleInQueue {

    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                answer[i]++;
            }

            if (!stack.isEmpty()) {
                answer[i]++;
            }

            stack.push(heights[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(canSeePersonsCount(heights)));
    }
}
