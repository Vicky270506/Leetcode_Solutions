class Solution {
    public int bitwiseComplement(int n) {
        char[] s = Integer.toBinaryString(n).toCharArray();
        double ans = 0.0;
        for(int i=s.length-1;i>=0;i--)
        {
            if(s[i] == '0')
            {
                ans += Math.pow(2,s.length-1-i);
            }
        }
        return (int)ans;
    }
}