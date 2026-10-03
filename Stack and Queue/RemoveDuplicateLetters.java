public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        boolean[] used = new boolean[26];

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            count[ch - 'a']--;

            if (used[ch - 'a']) {
                continue;
            }

            while (stack.length() > 0
                    && stack.charAt(stack.length() - 1) > ch
                    && count[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                char removed =
                    stack.charAt(stack.length() - 1);

                stack.deleteCharAt(stack.length() - 1);

                used[removed - 'a'] = false;
            }

            stack.append(ch);

            used[ch - 'a'] = true;
        }

        return stack.toString();
    }

    public static void main(String[] args) {

        System.out.println(
            "Result: " + removeDuplicateLetters("bcabc")
        );

        System.out.println(
            "Result: " + removeDuplicateLetters("cbacdcbc")
        );
    }
}