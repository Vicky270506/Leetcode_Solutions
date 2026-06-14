class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0) return;

        int n = nums.length, count = 0;

        for(int start = 0; count < n; start++)
        {
            int current = start;
            int prev = nums[current];

            do{
                int t = (start+k)%n;
                int next = nums[t];
                
                nums[t] = prev;

                start = t;
                count++;
                prev = next;
            }while( start != current );
        }
    }
}