package Arrays;
import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Convert word into character array
            char[] chars = word.toCharArray();

            // Sort the characters
            Arrays.sort(chars);

            // Convert sorted characters back to String
            String key = new String(chars);

            // Create a new list if key doesn't exist
            map.putIfAbsent(key, new ArrayList<>());

            // Add word to its anagram group
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {
            "eat",
            "tea",
            "tan",
            "ate",
            "nat",
            "bat"
        };

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }
}