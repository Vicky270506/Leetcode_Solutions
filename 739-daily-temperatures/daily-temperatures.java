import java.util.Stack;
import java.util.AbstractMap.SimpleEntry;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<SimpleEntry<Integer, Integer>> dailyTemperatures = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!dailyTemperatures.isEmpty() && dailyTemperatures.peek().getKey() < temperatures[i]) {
                SimpleEntry<Integer, Integer> prev = dailyTemperatures.pop();
                int index = prev.getValue();
                result[index] = i - index;
            }
            dailyTemperatures.push(new SimpleEntry<>(temperatures[i], i));
        }
        return result;
    }
}