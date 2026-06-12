class Solution {
    public int t;

    public int findKthLargest(int[] nums, int k) {
        t = nums.length - k;

        return quickSelect(nums, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int left, int right) {
        if(left == right)
        {
            return nums[left];
        }

        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        int pivot = nums[pivotIndex];

        int low = left, mid = left, high = right;

        while(mid <= high)
        {
            if(nums[mid] < pivot)
            {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] > pivot)
            {
                swap(nums, mid, high);
                high--;
            }
            else
            {
                mid++;
            }
        }
        
        if(t >= low && t <= high)
        {
            return nums[low];
        }
        else if( t < low )
        {
            return quickSelect(nums, left, low-1 );
        }
        else
        {
            return quickSelect(nums, high+1, right);
        }
    }

    private void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}