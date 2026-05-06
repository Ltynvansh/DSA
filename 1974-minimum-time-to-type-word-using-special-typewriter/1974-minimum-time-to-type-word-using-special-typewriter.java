class Solution {
    public int minTimeToType(String word) {
        int time =0;
        char current ='a';
        for(char ch : word.toCharArray() ){
            int diff = Math.abs(ch - current);
            int move = Math.min(diff, 26 - diff);
            time = time + move +1;
            current = ch;

        }
        return time ;

        
    }
}