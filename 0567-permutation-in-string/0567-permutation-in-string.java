class Solution {
   private boolean isFrequency(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];      // freq of s1
        int[] window = new int[26];    // sliding window freq in s2

        // build freq for s1
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int k = s1.length();

        // first window in s2
        for (int i = 0; i < k; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        if (isFrequency(freq, window)) return true;

        // slide window over s2
        for (int i = k; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;              // add new char
            window[s2.charAt(i - k) - 'a']--;          // remove old char

            if (isFrequency(freq, window)) return true;
        }

        return false;
    }
}