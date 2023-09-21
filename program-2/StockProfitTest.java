import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockProfitTest {
    @Test
    public void testFindMaxProfit() {
        // Test cases
        int[][] inputs = {{100, 180, 260, 310, 40, 535, 695}, {7, 6, 4, 3, 1}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {1}};
        int[] expectedOutputs = {655, -1, 4, -1, -1};
        for (int i = 0; i < inputs.length; i++) {
            int[] input = inputs[i];
            int expectedOutput = expectedOutputs[i];
            int actualOutput = StockProfit.findMaxProfit(input);
            assertEquals(expectedOutput, actualOutput, String.format("Input: %s, Expected Output: %d, Actual Output: %d", Arrays.toString(input), expectedOutput, actualOutput));
        }
    }
}
