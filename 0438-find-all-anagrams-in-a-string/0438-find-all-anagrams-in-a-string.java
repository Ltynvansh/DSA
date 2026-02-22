import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> result = new ArrayList<>();

        // Count frequency of characters in p
        for(char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {

            // Add current character to window
            sCount[s.charAt(i) - 'a']++;

            // Remove character if window size exceeds p.length()
            if(i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare arrays
            if(Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}