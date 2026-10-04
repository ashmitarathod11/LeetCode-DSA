import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] answer = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[i]) {

                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {

                answer[resultIndex] =
                    nums[deque.peekFirst()];

                resultIndex++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {
            1, 3, -1, -3, 5, 3, 6, 7
        };

        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.print("Maximums: ");

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}