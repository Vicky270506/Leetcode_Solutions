class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        
        // dp[i] stores the length of the longest valid subsequence ending at index i
        int[] dp = new int[n];
        // prev[i] stores the previous index in the longest subsequence ending at i
        int[] prev = new int[n];
        
        // Initialize dp and prev arrays
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxLength = 1;
        int endIndex = 0;
        
        // Fill dp and prev arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check all constraints:
                // 1. Groups must be different
                // 2. Words must have the same length
                // 3. Hamming distance must be exactly 1
                if (groups[i] != groups[j] && 
                    words[i].length() == words[j].length() &&
                    hammingDistance(words[i], words[j]) == 1 &&
                    dp[j] + 1 > dp[i]) {
                    
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    
                    // Update maxLength and endIndex if we found a longer subsequence
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }
        
        // Build the result by tracing back from the end index
        List<String> result = new ArrayList<>();
        while (endIndex != -1) {
            result.add(words[endIndex]);
            endIndex = prev[endIndex];
        }
        
        // Reverse the result to get the correct order
        Collections.reverse(result);
        return result;
    }
    
    // Helper function to calculate hamming distance between two strings
    private int hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) return -1; // Different lengths
        
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}