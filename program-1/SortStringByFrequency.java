package result;

import java.util.*;

public class SortStringByFrequency {
    public static String sortString(String str) {
        // Create a HashMap to store the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Create a List of Map entries and sort it by frequency in descending order
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        Collections.sort(entryList, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        // Build the sorted string by appending each character the number of times it appears in the original string
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            char c = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] inputs = {"hello world", "tree", "aaabbc", "ababab", "abcde"};
        String[] expectedOutputs = {"llloohe wrd", "eetr", "aaabbcc", "aaaabbb", "abcde"};
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expectedOutput = expectedOutputs[i];
            String actualOutput = sortString(input);
            System.out.printf("Input: %s, Expected Output: %s, Actual Output: %s%n", input, expectedOutput, actualOutput);
        }
    }
}
