
import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;

                int previousSign = stack.pop();
                int previousResult = stack.pop();

                result = previousResult
                       + previousSign * result;
            }
        }

        result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("1-(2+3)"));
    }
}
