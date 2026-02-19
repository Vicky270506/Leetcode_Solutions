class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prevGroup = 0;
        int currGroup = 1;  // first character count
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                ans += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }
        
        // Add last pair
        ans += Math.min(prevGroup, currGroup);
        
        return ans;
    }
}
