class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] n1path = checkPath(edges, node1);
        int[] n2path = checkPath(edges, node2);

        System.out.println(Arrays.toString(n1path) + " " + Arrays.toString(n2path));

        int minDist = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (n1path[i] != -1 && n2path[i] != -1) {
                int maxDist = Math.max(n1path[i], n2path[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    ans = i;
                }
            }
        }

        return ans;
    }

    private int[] checkPath(int[] edges, int start) {
        int n = edges.length;
        int[] path = new int[n];
        Arrays.fill(path, -1);
        int current = start;
        int distance = 0;
        while (current != -1 && path[current] == -1) {
            path[current] = distance++;
            current = edges[current];
        }
        return path;
    }
}