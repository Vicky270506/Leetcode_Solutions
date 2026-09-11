class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int ans = 0;

        // Choose the units digit
        for (int u = 0; u <= 8; u += 2) {
            if (freq[u] == 0) continue;

            freq[u]--;

            // Choose hundreds digit (1-9)
            int hundreds = 0;
            for (int h = 1; h <= 9; h++) {
                if (freq[h] > 0) {
                    hundreds++;
                }
            }

            if (hundreds == 0) {
                freq[u]++;
                continue;
            }

            // For each possible hundreds digit,
            // count possible tens digits.
            for (int h = 1; h <= 9; h++) {
                if (freq[h] == 0) continue;

                freq[h]--;

                int tens = 0;
                for (int t = 0; t <= 9; t++) {
                    if (freq[t] > 0) {
                        tens++;
                    }
                }

                ans += tens;

                freq[h]++;
            }

            freq[u]++;
        }

        return ans;
    }
}