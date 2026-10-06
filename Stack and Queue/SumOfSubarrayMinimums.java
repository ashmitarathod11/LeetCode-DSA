import java.util.Stack;

public class SumOfSubarrayMinimums {

    public static int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long MOD = 1_000_000_007L;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && arr[stack.peek()] > arr[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && arr[stack.peek()] >= arr[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            long contribution =
                arr[i] * leftChoices * rightChoices;

            answer = (answer + contribution) % MOD;
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 4};

        System.out.println(
            "Sum of Subarray Minimums: "
            + sumSubarrayMins(arr)
        );
    }
}