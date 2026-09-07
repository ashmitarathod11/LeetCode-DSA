import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String directory : stack) {
            result.append("/").append(directory);
        }

        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String path = "/home/user/../docs/./file/";

        String result = simplifyPath(path);

        System.out.println("Input: " + path);
        System.out.println("Simplified Path: " + result);
    }
}