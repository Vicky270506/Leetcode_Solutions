class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int counter = 1;
        for(int i=1;i<=word.length();i++){
            ans += counter;
            counter = (int) (i / 8) + 1;
        }
        return ans;
    }
}