class Solution {
    public int reverseDegree(String s) {
        int ans = 0, pos = 1;
        
        for(char c: s.toCharArray()){
            int t = c;
            ans += ((123 - t) * pos);
            pos++;
        }
        return ans;
    }
}