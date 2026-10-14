
import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int number = 0;
        char operator = '+';

        for (int i = 0; i <= s.length(); i++) {
            char ch = i < s.length() ? s.charAt(i) : '+';

            if (i < s.length() && Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (i == s.length() || ch != ' ') {
                if (operator == '+') {
                    stack.push(number);
                } else if (operator == '-') {
                    stack.push(-number);
                } else if (operator == '*') {
                    stack.push(stack.pop() * number);
                } else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }

                if (i < s.length()) {
                    operator = ch;
                }

                number = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate("14-3/2"));
    }
}
