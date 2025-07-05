class NumArray {
    int[] numArray;
    public NumArray(int[] nums) {
        numArray = new int[nums.length];
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            numArray[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return numArray[right];
        else
            return numArray[right] - numArray[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */