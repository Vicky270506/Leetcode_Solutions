class Solution {
    public int minOperations(String s) {
        String zero = buildAlternatingString(s.length(), 0);
        String one = buildAlternatingString(s.length(), 1);

        int z = (int)IntStream.range(0, s.length())
        .filter(i -> s.charAt(i) != one.charAt(i))
        .count();
        int o = (int)IntStream.range(0, s.length())
        .filter(i -> s.charAt(i) != zero.charAt(i))
        .count();
        return o <= z ? o : z;
    }
    public static String buildAlternatingString(int length, int val) {
        if (length <= 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // Append '0' for even indices and '1' for odd indices (0-indexed)
            if (i % 2 == val) {
                builder.append('0');
            } else {
                builder.append('1');
            }
        }

        return builder.toString();
    }
}