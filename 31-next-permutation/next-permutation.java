class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i] < nums[i+1])
            {
                pivot = i;
                for(int k=nums.length-1;k>=0;k--)
                {
                    if(nums[pivot] < nums[k])
                    {
                        swap(nums, pivot, k);
                        int left = pivot + 1;
                        int right = nums.length-1;
                        while(left < right)
                        {
                            swap(nums, left, right);
                            left++;
                            right--;
                        }
                        return;
                    }
                    
                }
            }
        }
        if(pivot == -1)
        {
            Arrays.sort(nums);
        }
    }
    private void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}