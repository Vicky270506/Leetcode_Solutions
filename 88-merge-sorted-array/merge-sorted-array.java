class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0,k=m; k<m+n;k++,++i)
        {
            nums1[k]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}