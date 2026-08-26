import java.util.Arrays;

public class FindFirstLastPosition {

    public static int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            System.out.println(
                "First Search → left = " + left +
                ", mid = " + mid +
                ", right = " + right
            );

            if (nums[mid] == target) {
                answer = mid;
                right = mid - 1;
            }

            else if (nums[mid] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            System.out.println(
                "Last Search → left = " + left +
                ", mid = " + mid +
                ", right = " + right
            );

            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;
            }

            else if (nums[mid] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        System.out.println("First Position = " + first);
        System.out.println("Last Position = " + last);

        System.out.println(
            "Answer = " + Arrays.toString(new int[]{first, last})
        );
    }
}