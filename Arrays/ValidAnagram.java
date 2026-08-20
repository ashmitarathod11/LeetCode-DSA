package Arrays;
import java.util.Scanner;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Count characters in s and subtract characters in t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        boolean result = isAnagram(s, t);

        System.out.println("Output: " + result);

        sc.close();
    }
}
