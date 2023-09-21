public class ValidateIPAddress {
    public static boolean isValidIPAddress(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        try {
            String[] parts = str.split("\\.");
            if (parts.length != 4) {
                return false;
            }
            
            for (String part : parts) {
                if (!isValidIPPart(part)) {
                    return false;
                }
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean isValidIPPart(String part) {
        if (part == null || part.isEmpty()) {
            return false;
        }
        
        if (part.charAt(0) == '0' && part.length() > 1) {
            return false;
        }
        
        try {
            int num = Integer.parseInt(part);
            return num >= 0 && num <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] inputs = {"255.255.0.0", "555.555.555.555", "256.255.0.0", "", null, "1.2.3.4.5", "1.2.3.a"};
        boolean[] expectedOutputs = {true, false, true, false, false, false, false};
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            boolean expectedOutput = expectedOutputs[i];
            boolean actualOutput = isValidIPAddress(input);
            assert actualOutput == expectedOutput : String.format("Input: %s, Expected Output: %b, Actual Output: %b", input, expectedOutput, actualOutput);
        }
    }
}
