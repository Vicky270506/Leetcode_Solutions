class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] m = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        char[] ans = new char[words.length];
        int i=0;
        for(String w :  words)
        {
            int weight = 0;
            for(char c : w.toCharArray())
            {
                weight += weights[c - 97];
            }
            ans[i++] = (m[weight%26]);
        }
        return new String(ans);
    }
}