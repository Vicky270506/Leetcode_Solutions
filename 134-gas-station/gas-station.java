class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            
            // Add what we fill up, subtract what it costs to move to the next
            currentTank += gas[i] - cost[i];
            
            // If we ran out of gas, this starting station (and any station before it) is invalid
            if (currentTank < 0) {
                startingStation = i + 1; // Try the next station
                currentTank = 0;         // Reset our tank
            }
        }

        // If we don't have enough gas overall to cover the total cost, it's impossible
        if (totalGas < totalCost) {
            return -1;
        }

        return startingStation;
    }
}