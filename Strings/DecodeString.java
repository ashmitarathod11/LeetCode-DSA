import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currentString = "";
        int currentNumber = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                currentNumber = currentNumber * 10 + (ch - '0');

            } 
            else if (ch == '[') {

                numberStack.push(currentNumber);
                stringStack.push(currentString);

                currentNumber = 0;
                currentString = "";

            } 
            else if (ch == ']') {

                int repeat = numberStack.pop();
                String previousString = stringStack.pop();

                StringBuilder temp = new StringBuilder(previousString);

                for (int j = 0; j < repeat; j++) {
                    temp.append(currentString);
                }

                currentString = temp.toString();

            } 
            else {

                currentString += ch;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {

        String s = "3[a2[c]]";

        String result = decodeString(s);

        System.out.println("Input: " + s);
        System.out.println("Decoded String: " + result);
    }
}