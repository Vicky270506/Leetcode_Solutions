class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for(int i: nums)
        {
            if(i < 0)
            {
                neg.add(i);
            }
            else
            {
                pos.add(i);
            }
        }

        for(int i=0;i<nums.length; i++)
        {
            if(i%2 == 0)
            {
                nums[i] = pos.get((int)i/2);
            }
            else
            {
                nums[i] = neg.get((int)i/2);
            }
        }
        System.gc();
        return nums;
    }
}