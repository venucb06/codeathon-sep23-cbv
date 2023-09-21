import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateIPAddressTest {
    @Test
    public void testIsValidIPAddress() {
        // Test cases
        String[] inputs = {"255.255.0.0", "555.555.555.555", "256.255.0.0", "", null, "1.2.3.4.5", "1.2.3.a", "1.2.3.04", "1.2.3.004", "1.2.3.0004"};
        boolean[] expectedOutputs = {true, false, true, false, false, false, false, false, true, true};
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            boolean expectedOutput = expectedOutputs[i];
            boolean actualOutput = ValidateIPAddress.isValidIPAddress(input);
            assertEquals(expectedOutput, actualOutput, String.format("Input: %s, Expected Output: %b, Actual Output: %b", input, expectedOutput, actualOutput));
        }
    }
@Test
public void testIsValidIPAddress() {
    // Valid IP addresses
    assertTrue(ValidateIPAddress.isValidIPAddress("0.0.0.0"));
    assertTrue(ValidateIPAddress.isValidIPAddress("255.255.255.255"));
    assertTrue(ValidateIPAddress.isValidIPAddress("192.168.0.1"));
    assertTrue(ValidateIPAddress.isValidIPAddress("172.16.0.1"));
    assertTrue(ValidateIPAddress.isValidIPAddress("10.0.0.1"));
    
    // Invalid IP addresses
    assertFalse(ValidateIPAddress.isValidIPAddress(""));
    assertFalse(ValidateIPAddress.isValidIPAddress(null));
    assertFalse(ValidateIPAddress.isValidIPAddress("1.2.3"));
    assertFalse(ValidateIPAddress.isValidIPAddress("1.2.3.4.5"));
    assertFalse(ValidateIPAddress.isValidIPAddress("1.2.3.4.5.6"));
}
  
}
