import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeProfit {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Min-heap based on the capital required
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Max-heap based on the profit
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Insert all projects into the minCapitalHeap
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        int currentCapital = w;

        for (int i = 0; i < k; i++) {
            // Transfer all projects that can be done with the current capital to the maxProfitHeap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= currentCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            // If there are no projects that can be done, break out of the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Complete the project with the highest profit
            currentCapital += maxProfitHeap.poll()[1];
        }

        return currentCapital;
    }
}
