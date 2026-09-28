import java.util.Stack;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int currentIndex = i % n;

            while (!stack.isEmpty()
                    && nums[currentIndex] > nums[stack.peek()]) {

                int index = stack.pop();
                answer[index] = nums[currentIndex];
            }

            if (i < n) {
                stack.push(currentIndex);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int[] result = nextGreaterElements(nums);

        System.out.print("Answer: ");

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}