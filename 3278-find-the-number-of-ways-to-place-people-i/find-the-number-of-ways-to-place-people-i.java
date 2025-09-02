class Solution {
    public int numberOfPairs(int[][] points) {
        int N = points.length;
        int count = 0;

        // Iterate through all possible points to be the "upper-left" point A
        for (int i = 0; i < N; i++) {
            int ax = points[i][0];
            int ay = points[i][1];

            // Iterate through all possible points to be the "lower-right" point B
            for (int j = 0; j < N; j++) {
                // A and B must be two distinct points
                if (i == j) continue;

                int bx = points[j][0];
                int by = points[j][1];

                // The condition for A being on the upper-left side of B is:
                // ax <= bx (A's x-coordinate is less than or equal to B's)
                // ay >= by (A's y-coordinate is greater than or equal to B's)
                // This correctly handles cases where they form a horizontal or vertical line.
                if (ax > bx || ay < by) {
                    continue;
                }

                boolean foundIntermediate = false;
                // Now, check if any other point C lies within the rectangle formed by A and B.
                for (int k = 0; k < N; k++) {
                    // The point C cannot be A or B themselves
                    if (k == i || k == j) {
                        continue;
                    }

                    int cx = points[k][0];
                    int cy = points[k][1];

                    // A point C(cx, cy) is inside the rectangle if it satisfies
                    // the following conditions:
                    // 1. Its x-coordinate is between A and B's x-coordinates.
                    //    (ax <= cx <= bx)
                    // 2. Its y-coordinate is between A and B's y-coordinates.
                    //    (by <= cy <= ay)
                    if (ax <= cx && cx <= bx && by <= cy && cy <= ay) {
                        foundIntermediate = true;
                        break; // Found an intermediate point, no need to check further
                    }
                }

                // If no intermediate point was found, this pair (A, B) is valid.
                if (!foundIntermediate) {
                    count++;
                }
            }
        }
        return count;
    }
}
