class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_water=0
        l=0
        r=len(height)-1
        while l<r:
            width=r-l
            h=min(height[l], height[r])
            ar=h*width
            max_water=max(ar,max_water)
            if height[l] > height[r]:
                r-=1
            else:
                l+=1
        return max_water
        