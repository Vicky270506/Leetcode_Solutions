class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0, right = 0;
        int length = std::numeric_limits<int>::max();
        int sum = 0;
        for(int right=0;right<nums.size();right++)
        {
            sum += nums[right];
            
            while(sum >= target)
            {
                length = std::min(length, right - left + 1);
                sum -= nums[left];
                left++;
            }
            
        }
        return length == std::numeric_limits<int>::max() ? 0 : length;
    }
};