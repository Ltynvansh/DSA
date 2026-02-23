class Solution {
public:
    
    // Function to check if substring is palindrome
    bool isPalin(string &s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    // Backtracking function
    void solve(int index, string &s, vector<string> &path, 
               vector<vector<string>> &result) {
        
        // If we reached end of string
        if (index == s.size()) {
            result.push_back(path);
            return;
        }

        for (int i = index; i < s.size(); i++) {
            if (isPalin(s, index, i)) {
                // Choose
                path.push_back(s.substr(index, i - index + 1));
                
                // Explore
                solve(i + 1, s, path, result);
                
                // Backtrack
                path.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> path;
        solve(0, s, path, result);
        return result;
    }
};
