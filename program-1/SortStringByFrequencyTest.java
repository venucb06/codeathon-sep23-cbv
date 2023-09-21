import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortStringByFrequencyTest {
    @Test
    public void testSortString() {
        // Test cases
        String[] inputs = {"hello world", "tree", "aaabbc", "ababab", "abcde"};
        String[] expectedOutputs = {"llloohe wrd", "eetr", "aaabbcc", "aaaabbb", "abcde"};
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expectedOutput = expectedOutputs[i];
            String actualOutput = SortStringByFrequency.sortString(input);
            assertEquals(expectedOutput, actualOutput, String.format("Input: %s, Expected Output: %s, Actual Output: %s", input, expectedOutput, actualOutput));
        }
    }
}
