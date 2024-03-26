class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] b = new boolean[nums.length];
        for(int num:nums){
            if(b[num])return num;
            b[num] = true;
        }
        return 0;
    }
}