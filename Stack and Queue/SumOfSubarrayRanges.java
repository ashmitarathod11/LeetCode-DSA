import java.util.Stack;

public class SumOfSubarrayRanges {

    public static long subArrayRanges(int[] nums) {

        long maximumSum = getMaximumSum(nums);
        long minimumSum = getMinimumSum(nums);

        return maximumSum - minimumSum;
    }

    private static long getMinimumSum(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty()
                    ? -1
                    : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty()
                    ? n
                    : stack.peek();

            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            sum += (long) nums[i]
                    * leftChoices
                    * rightChoices;
        }

        return sum;
    }

    private static long getMaximumSum(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty()
                    ? -1
                    : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty()
                    ? n
                    : stack.peek();

            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            sum += (long) nums[i]
                    * leftChoices
                    * rightChoices;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(
            "Sum of Subarray Ranges: "
            + subArrayRanges(nums)
        );
    }
}
