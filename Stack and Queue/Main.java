public class Main {

    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;

        // Step 1: Remove extra closing parentheses ')'
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                result.append(ch);
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }

        // Step 2: Remove extra opening parentheses '('
        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {
            char ch = result.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
            } else {
                answer.append(ch);
            }
        }

        // Reverse because we processed the string backwards
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";

        String result = minRemoveToMakeValid(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}