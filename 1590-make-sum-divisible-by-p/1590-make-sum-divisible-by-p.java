class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;

        long need = total % p;
        if (need == 0) return 0;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1); // prefix before array

        long prefix = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            long want = (prefix - need + p) % p;

            if (map.containsKey(want)) {
                minLen = Math.max(1, Math.min(minLen, i - map.get(want))); 
            }

            map.put(prefix, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }
}
