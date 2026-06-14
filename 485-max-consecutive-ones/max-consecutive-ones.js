/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    let i = 0;
    let m = 0;
    let mx = 0;
    
    while(i <= nums.length)
    {
        if(nums[i] != 1)
        {
            mx = Math.max(mx, m);
            m = 0;
        }
        else
        {
            m++;
        }
        i++;
        
    }
    return mx;
};