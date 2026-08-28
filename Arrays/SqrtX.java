public class SqrtX {

    public static int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x;
        int answer = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            System.out.println(
                "left = " + left +
                ", mid = " + mid +
                ", right = " + right
            );

            if (mid * mid <= x) {

                answer = (int) mid;

                System.out.println("Valid mid = " + mid);

                left = mid + 1;

            } else {

                System.out.println("Too large: " + mid);

                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int x = 8;

        int answer = mySqrt(x);

        System.out.println("x = " + x);
        System.out.println("Square Root = " + answer);
    }
}
