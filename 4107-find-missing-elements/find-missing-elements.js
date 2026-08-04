/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findMissingElements = function(nums) {
    let l = Math.min(...nums);
    let r = Math.max(...nums);

    let s = new Set(nums);
    const ans = [];

    for(let i=l;i<=r;i++){
        if(!s.has(i)){
            ans.push(i);
        }
    }
    return ans;
};