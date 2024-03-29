class Solution {
    public long countSubarrays(int[] nums, int k) {
        int m = nums[0];
        for(int i:nums){
            m = m>i ? m:i;
        }
        int i=0, curr=0;
        long res = 0;
        for(int j=0; j<nums.length; j++){
            curr += nums[j] == m ? 1:0;
            while(curr >= k){
                curr -= nums[i++] == m ? 1:0;
            }
            res += i;
        }
        return res;
    }
}