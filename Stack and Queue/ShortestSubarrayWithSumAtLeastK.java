import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int answer = n + 1;

        for (int i = 0; i <= n; i++) {

            while (!deque.isEmpty()
                    && prefix[i] - prefix[deque.peekFirst()] >= k) {

                answer = Math.min(
                    answer,
                    i - deque.pollFirst()
                );
            }

            while (!deque.isEmpty()
                    && prefix[deque.peekLast()] >= prefix[i]) {

                deque.pollLast();
            }

            deque.addLast(i);
        }

        return answer == n + 1 ? -1 : answer;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, -1, 2};

        System.out.println(
            "Answer: " + shortestSubarray(nums1, 3)
        );

        int[] nums2 = {1, 2, 3, 4, 5};

        System.out.println(
            "Answer: " + shortestSubarray(nums2, 11)
        );

        int[] nums3 = {1, 2};

        System.out.println(
            "Answer: " + shortestSubarray(nums3, 10)
        );
    }
}