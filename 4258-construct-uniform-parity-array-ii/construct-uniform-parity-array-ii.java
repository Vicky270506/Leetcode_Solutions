class Solution {
    public boolean uniformArray(int[] nums) {
        int minOdd = -1;
        int minEven = -1;

        for(int i: nums) {
            if(i%2 ==0){
                if(minEven == -1) {
                    minEven = i;
                }
                else {
                    minEven = i < minEven ? i : minEven;
                }
            }
            else{
                if(minOdd == -1) {
                    minOdd = i;
                }
                else {
                    minOdd = i < minOdd ? i : minOdd;
                }
            }
        }
        //System.out.println(minOdd + " " + minEven);
        if(minOdd == -1 || minEven == -1) {
            return true;
        }
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];

        for(int i=0;i<n;i++) {
            if(nums[i]%2 == 1) {
                odd[i] = nums[i];
            }
            else{
                odd[i] = nums[i] - minOdd;
                if(odd[i] < 1 || odd[i]%2 == 0){
                    minOdd = -1;
                    break;
                }
            }
        }
        if(minOdd != -1) {
            return true;
        }
        //System.out.println(Arrays.toString(odd));
        for(int i=0;i<n;i++) {
            if(nums[i]%2 == 0) {
                even[i] = nums[i];
            }
            else{
                even[i] = nums[i] - minEven;
                if(even[i] < 1 || even[i]%2 == 1){
                    minEven = -1;
                    break;
                }
            }
        }
        if(minEven != -1) {
            return true;
        }
        else
        {
            return false;
        }
    }
}