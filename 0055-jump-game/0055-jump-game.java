class Solution {
    public boolean canJump(int[] nums) {

        int max = 0;
        int i = 0;

        while(i < nums.length && i <= max){

            max = Math.max(max, i + nums[i]);

            if(max >= nums.length - 1){
                return true;
            }

            i++;
        }

        return false;
    }
}