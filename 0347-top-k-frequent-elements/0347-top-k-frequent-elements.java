class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find top k elements
        for (int i = 0; i < k; i++) {
            int max = 0;
            int element = 0;

            // Find max frequency element
            for (int key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    element = key;
                }
            }

            // AFTER loop (correct place)
            result[i] = element;
            map.remove(element);
        }

        return result;
    }
}