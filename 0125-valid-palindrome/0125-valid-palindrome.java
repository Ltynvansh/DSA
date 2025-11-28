class Solution {
    private boolean isAlphanumeric(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false; // optional: handle null input
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // move start forward until it points at an alphanumeric char
            while (start < end && !isAlphanumeric(s.charAt(start))) {
                start++;
            }
            // move end backward until it points at an alphanumeric char
            while (start < end && !isAlphanumeric(s.charAt(end))) {
                end--;
            }

            // compare lowercased characters
            char c1 = Character.toLowerCase(s.charAt(start));
            char c2 = Character.toLowerCase(s.charAt(end));
            if (c1 != c2) return false;

            start++;
            end--;
        }

        return true;
    }
}