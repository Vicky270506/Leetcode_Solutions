class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1; 
        while(right>=left){
            if(numbers[left]+numbers[right]==target){
                System.gc();
                return new int[]{left+1,right+1};
            }
            else if(numbers[left]+numbers[right]<target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{left+1,right+1};
    }
}