class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int alt = 0;
        for(int i: gain)
        {
            alt += i;
            ans = Math.max(ans, alt);
        }
        return ans;
    }
}