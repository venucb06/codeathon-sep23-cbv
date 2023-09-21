/**
 * A class that provides a method for finding the best days to buy and sell stocks to maximize profit.
 */
public class StockProfit {
    /**
     * Finds the best days to buy and sell stocks to maximize profit and returns the maximum profit.
     * If no profit can be made, returns -1.
     * @param prices an array of stock prices
     * @return the maximum profit that can be made
     */
    public static int findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return -1;
        }
        
        int buyDay = 0;
        int sellDay = 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for (int i = 1; i < n; i++) {
            int price = prices[i];
            if (price < minPrice) {
                minPrice = price;
                buyDay = i;
                sellDay = i;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
                sellDay = i;
            }
        }
        
        if (maxProfit == 0) {
            return -1;
        } else {
            System.out.printf("Buy on day %d at price %d%n", buyDay + 1, prices[buyDay]);
            System.out.printf("Sell on day %d at price %d%n", sellDay + 1, prices[sellDay]);
            System.out.printf("Max profit: %d%n", maxProfit);
            return maxProfit;
        }
    }
    
    /**
     * A main method that tests the findMaxProfit method with sample inputs and expected outputs.
     * Prints the input, expected output, and actual output for each test case.
     * If the actual output matches the expected output, the test case passes.
     * If the actual output does not match the expected output, the test case fails.
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases
        int[][] inputs = {{100, 180, 260, 310, 40, 535, 695}, {7, 6, 4, 3, 1}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {1}};
        int[] expectedOutputs = {655, -1, 4, -1, -1};
        for (int i = 0; i < inputs.length; i++) {
            int[] input = inputs[i];
            int expectedOutput = expectedOutputs[i];
            int actualOutput = findMaxProfit(input);
            assert actualOutput == expectedOutput : String.format("Input: %s, Expected Output: %d, Actual Output: %d", Arrays.toString(input), expectedOutput, actualOutput);
        }
    }
}
