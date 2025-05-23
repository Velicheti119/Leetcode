class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty()) return 0;
        if(nums.size() == 1) return nums[0];

        vector<int> dp(nums.size());
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i = 2; i < nums.size() - 1; i++) {
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        int secondLast = dp[nums.size() - 2];

        dp[1] = nums[1];
        dp[2] = max(nums[1], nums[2]);
        for(int i = 3; i < nums.size(); i++) {
            dp[i] = max(dp[i-1], nums[i] + dp[i-2]);
        }
        int last = dp[nums.size() - 1];

        return max(secondLast, last);
    }
};
