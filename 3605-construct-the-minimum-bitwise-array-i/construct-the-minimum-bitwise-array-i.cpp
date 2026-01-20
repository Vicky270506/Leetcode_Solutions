class Solution {
public:
    vector<int> minBitwiseArray(vector<int>& nums) {
        int tem;
        vector<int>result;
        for(int t : nums){
            int tem =-1;
            for(int i = 1; i<=t;i++){
                if((i | (i+1)) == t)
                {
                    tem=i;
                    break;
                }
            }
            result.push_back(tem);    
        }
        return result;      
    }
};