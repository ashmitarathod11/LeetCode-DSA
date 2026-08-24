import java.util.HashMap;

public class SubarraysDivisibleByK {

    public static int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            int remainder = ((sum % k) + k) % k;

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {5};
        int k = 5;

        int result = subarraysDivByK(nums, k);

        System.out.println("Number of subarrays divisible by K: " + result);
    }
}