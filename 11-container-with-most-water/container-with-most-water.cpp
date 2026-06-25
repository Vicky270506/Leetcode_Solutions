class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size()-1;
        int max_area = 0;

        while(left <= right && left < height.size()-1)
        {
            max_area = std::max(max_area, std::min(height[left], height[right])*(right-left));
            if(height[left] <= height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return max_area;
    }
};