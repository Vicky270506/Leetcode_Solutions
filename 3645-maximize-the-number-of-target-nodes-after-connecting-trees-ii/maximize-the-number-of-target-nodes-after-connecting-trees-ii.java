import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        // Build adjacency lists for both graphs
        List<Integer>[] graph1 = buildGraph(edges1);
        List<Integer>[] graph2 = buildGraph(edges2);
        
        int n = graph1.length;
        int m = graph2.length;
        
        // Arrays to store color/label for each node (0 or 1 based on depth parity)
        int[] color1 = new int[n];  
        int[] color2 = new int[m];
        
        // Arrays to count nodes in each color group
        int[] count1 = new int[2]; // count1[0] = nodes with color 0, count1[1] = nodes with color 1
        int[] count2 = new int[2];
        
        // Perform DFS on both graphs to assign colors and count
        dfs(graph2, 0, -1, color2, 0, count2);
        dfs(graph1, 0, -1, color1, 0, count1);
        
        // Find the maximum count from tree2 (we can connect to either color group)
        int maxCount2 = Math.max(count2[0], count2[1]);
        
        // For each node in tree1, the answer is:
        // nodes with same color in tree1 + max nodes from any color in tree2
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = count1[color1[i]] + maxCount2;
        }
        
        return result;
    }
    
    private List<Integer>[] buildGraph(int[][] edges) {
        int n = edges.length + 1; // n-1 edges means n nodes
        
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        return graph;
    }
    
    private void dfs(List<Integer>[] graph, int node, int parent, int[] color, int depth, int[] count) {
        // Assign color based on depth parity (0 for even depth, 1 for odd depth)
        color[node] = depth;
        count[depth]++; // Increment count for this color
        
        // Visit all neighbors
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                // Alternate depth using XOR (0^1=1, 1^1=0)
                dfs(graph, neighbor, node, color, depth ^ 1, count);
            }
        }
    }
}