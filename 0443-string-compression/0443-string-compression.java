class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;      // write pointer
        int i = 0;          // read pointer

        while (i < n) {
            char ch = chars[i];
            int count = 0;

            // count how many times chars[i] repeats
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            // write the character
            chars[index++] = ch;

            // write the count (only if > 1)
            if (count > 1) {
                String s = Integer.toString(count);
                for (char c : s.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; 
    }
}