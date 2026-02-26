import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        BigInteger n = new BigInteger(s, 2);
        BigInteger two = BigInteger.valueOf(2);
        int steps = 0;

        while(n.compareTo(BigInteger.ONE) != 0)
        {
            if((n.mod(two)).equals(BigInteger.ZERO))
            {
                n = n.divide(two);
            }
            else
            {
                n = n.add(BigInteger.ONE);
            }
            steps++;
        }
        return steps;
    }
}