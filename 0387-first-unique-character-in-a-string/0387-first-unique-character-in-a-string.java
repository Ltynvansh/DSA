import java.util.*;

class Solution {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> m = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(!m.containsKey(c)) {
                q.add(i);
            }

            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        while(!q.isEmpty() && m.get(s.charAt(q.peek())) > 1) {
            q.poll();
        }

        return q.isEmpty() ? -1 : q.peek();
    }
}