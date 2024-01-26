import java.util.Vector;
import java.util.Arrays;
public class StockTrader {
    public static Triplet findMaximumSubarray(Vector<Integer> A, int low, int high) {
        if (high == low) {
            return new Triplet(low, high, A.get(low)); // Base case: single element
        } else {
            int mid = (low + high) / 2;
            Triplet left = findMaximumSubarray(A, low, mid);
            Triplet right = findMaximumSubarray(A, mid + 1, high);
            Triplet cross = findMaxCrossingSubarray(A, low, mid, high);
            if (left.sum >= right.sum && left.sum >= cross.sum) {
                return left;
            } else if (right.sum >= left.sum && right.sum >= cross.sum) {
                return right;
            } else {
                return cross;
            }
        }
    }
    public static Triplet findMaxCrossingSubarray(Vector<Integer> A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + A.get(i);
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + A.get(j);
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new Triplet(maxLeft, maxRight, leftSum + rightSum);
    }
    public static Pair findOptimalTradePoints(Vector<Integer> stockPrices) {
        Triplet maxSubarray = findMaximumSubarray(stockPrices, 0, stockPrices.size() - 1);
        int buyIndex = maxSubarray.low;
        int sellIndex = maxSubarray.high;
        if (buyIndex > sellIndex) {
            buyIndex = 0;
        }
        return new Pair(buyIndex, sellIndex);
    }
    static class Triplet {
        int low, high, sum;
        public Triplet(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }
    static class Pair {
        int buyIndex, sellIndex;
        public Pair(int buyIndex, int sellIndex) {
            this.buyIndex = buyIndex;
            this.sellIndex = sellIndex;
        }
    }
    public static void main(String[] args) {
        // Example usage:
        Vector<Integer> stockPrices = new Vector<>(Arrays.asList(10, 5, 20, 8, 17, 1));
        Pair tradePoints = findOptimalTradePoints(stockPrices);
        System.out.println("Buy at index: " + tradePoints.buyIndex + ", Sell at index: " + tradePoints.sellIndex);
    }
}

