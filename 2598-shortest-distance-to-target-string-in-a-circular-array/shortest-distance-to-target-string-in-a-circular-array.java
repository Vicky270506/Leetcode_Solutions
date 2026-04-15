class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++)
        {
            if(words[i].equals(target))
            {
                int diff = Math.abs(i-startIndex);
                ans = Math.min(ans, Math.min(diff, words.length - diff));
                System.out.println(i);
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}