class Solution {
public:
    void set(vector<int> &temp,vector<int> & nums, int st ,int end,vector<vector<int>> &arr){
        if(st>end){
            arr.push_back(temp);
            return;
        }
        // not pick
        set(temp,nums,st+1,end,arr);
        // pick
        temp.push_back(nums[st]);
        set(temp,nums,st+1,end,arr);
        temp.pop_back();
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> arr;
        vector<int> temp;
        set(temp,nums,0,nums.size()-1,arr);
        return arr;
    }
};

