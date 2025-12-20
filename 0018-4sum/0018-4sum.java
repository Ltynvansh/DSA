class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // STEP 1: Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int p = j + 1;
                int q = n - 1;

                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if (sum < target) {
                        p++;
                    } 
                    else if (sum > target) {
                        q--;
                    } 
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;

                        // Skip duplicate p
                        while (p < q && nums[p] == nums[p - 1]) p++;
                        // Skip duplicate q
                        while (p < q && nums[q] == nums[q + 1]) q--;
                    }
                }
            }
        }
        return ans;
    }
}
