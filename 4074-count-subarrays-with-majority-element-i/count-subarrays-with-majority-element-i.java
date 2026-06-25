class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        for(int i=1;i<=nums.length;i++)
        {
            int left = 0;
            int right = 0;
            int t_count = 0;
            LinkedList<Integer> t = new LinkedList<Integer>();
            while(left <= right && right < nums.length)
            {
                if(t.size() < i)
                {
                    t.add(nums[right]);
                    if(nums[right] == target)
                    {
                        t_count++;
                    }
                    right++;
                }
                else
                {
                    if(2*t_count > t.size())
                    {
                        count++;
                    }
                    int v = t.removeFirst();
                    if(v == target)
                    {
                        t_count--;
                    }
                    left++;
                }
            }
            if(2*t_count > t.size())
                    {
                        count++;
                    }
        }
        return count;
    }
}