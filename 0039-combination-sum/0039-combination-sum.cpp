class Solution {
public:
    void solve(vector<int>& candidates, int target, int index,
               vector<int>& current, vector<vector<int>>& result) {
        
        // Base Case
        if (target == 0) {
            result.push_back(current);
            return;
        }

        if (index >= candidates.size() || target < 0) {
            return;
        }

        // Include current element
        current.push_back(candidates[index]);
        solve(candidates, target - candidates[index], index, current, result);
        current.pop_back();

        // Exclude current element
        solve(candidates, target, index + 1, current, result);
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> current;
        solve(candidates, target, 0, current, result);
        return result;
    }
};