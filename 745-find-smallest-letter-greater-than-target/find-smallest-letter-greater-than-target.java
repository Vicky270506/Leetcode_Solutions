class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        char ans = letters[0];
        if(target == 'z')
        {
            return ans;
        }
        else
        {
            while(left<=right)
            {
                int mid = left + (right-left) / 2;
                if(letters[mid] - 'a' >= (target - 'a') + 1)
                {
                    ans = letters[mid];
                }
                if(letters[mid] - 'a' <= target - 'a')
                {
                    left = mid+1;
                }
                else if(left == right)
                {
                    break;
                }
                else
                {
                    right = mid;
                }
            }
        }
        return ans;
    }
}