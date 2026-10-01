import java.util.Stack;

public class OnlineStockSpan {

    static class StockSpanner {

        Stack<int[]> stack;

        StockSpanner() {
            stack = new Stack<>();
        }

        int next(int price) {

            int span = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }

            stack.push(new int[]{price, span});

            return span;
        }
    }

    public static void main(String[] args) {

        StockSpanner spanner = new StockSpanner();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.print("Spans: ");

        for (int price : prices) {
            System.out.print(spanner.next(price) + " ");
        }
    }
}