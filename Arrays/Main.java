import java.util.*;

public class Main {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Step 3: Add elements to heap
        for (int num : map.keySet()) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Create result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
d 
    public static void main(String[] args) {

        // Input
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Call the function
        int[] result = topKFrequent(nums, k);

        // Print the output
        System.out.println(Arrays.toString(result));
    }
}