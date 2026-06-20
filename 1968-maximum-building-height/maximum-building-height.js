/**
 * @param {number} n
 * @param {number[][]} restrictions
 * @return {number}
 */
var maxBuilding = function(n, restrictions) {
    // 1. Add our implicit base restrictions
    // Building 1 is always height 0
    restrictions.push([1, 0]);
    
    // Building n has no specific restriction, but the absolute highest 
    // it could ever be is n-1 (growing by 1 from building 1)
    restrictions.push([n, n - 1]); 
    
    // 2. Sort the restrictions strictly by building ID (left to right)
    restrictions.sort((a, b) => a[0] - b[0]);
    
    let m = restrictions.length;
    
    // 3. Left-to-Right Pass: Propagate constraints forward
    // A building's height cannot exceed the previous building's height + the distance between them
    for (let i = 1; i < m; i++) {
        let dist = restrictions[i][0] - restrictions[i-1][0];
        restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i-1][1] + dist);
    }
    
    // 4. Right-to-Left Pass: Propagate constraints backward
    // A building's height cannot exceed the next building's height + the distance between them
    for (let i = m - 2; i >= 0; i--) {
        let dist = restrictions[i+1][0] - restrictions[i][0];
        restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i+1][1] + dist);
    }
    
    // 5. Calculate the maximum possible peak between any two adjacent restrictions
    let maxHeight = 0;
    
    for (let i = 1; i < m; i++) {
        let h1 = restrictions[i-1][1];
        let h2 = restrictions[i][1];
        let dist = restrictions[i][0] - restrictions[i-1][0];
        
        // The highest peak between these two buildings forms a triangle shape (/\)
        let peak = Math.floor((h1 + h2 + dist) / 2);
        maxHeight = Math.max(maxHeight, peak);
    }
    
    return maxHeight;
};