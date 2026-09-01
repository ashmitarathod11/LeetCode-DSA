import java.util.*;

public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        // If s is shorter than p, an anagram is impossible
        if (s.length() < p.length()) {
            return result;
        }

        // Frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Count characters of p
        for (char ch : p.toCharArray()) {
            count[ch - 'a']++;
        }

        int windowSize = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            // Add current character
            count[s.charAt(i) - 'a']--;

            // Remove character that goes outside the window
            if (i >= windowSize) {
                count[s.charAt(i - windowSize) - 'a']++;
            }

            // Check when window reaches required size
            if (i >= windowSize - 1 && isAnagram(count)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    // Check whether all frequency differences are zero
    public static boolean isAnagram(int[] count) {

        for (int value : count) {

            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> answer = findAnagrams(s, p);

        System.out.println("String: " + s);
        System.out.println("Pattern: " + p);
        System.out.println("Anagram starting indices: " + answer);
    }
}