/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    let n = nums.length;
    let s = nums.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
    return (n*(n+1))/2 - s;
};