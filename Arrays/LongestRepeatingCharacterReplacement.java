public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int[] frequency = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';

            frequency[index]++;

            maxFrequency = Math.max(maxFrequency, frequency[index]);

            int windowLength = right - left + 1;

            int replacements = windowLength - maxFrequency;

            while (replacements > k) {

                int leftIndex = s.charAt(left) - 'A';

                frequency[leftIndex]--;

                left++;

                windowLength = right - left + 1;

                replacements = windowLength - maxFrequency;
            }

            maxLength = Math.max(maxLength, windowLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);

        System.out.println("Longest repeating character substring: " + result);
    }
}