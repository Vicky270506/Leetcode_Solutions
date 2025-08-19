class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0, current = 0;
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]==0)
            {
                current++;
            }
            else
            {
                if(current!=0)
                {
                    result += (current * (current+1)) / 2;
                    current = 0;
                }
            }
        }
        System.out.print(current);
        if(current!=0)
        {
            result += (current * (current+1)) / 2;
        }
        return result;
    }
}