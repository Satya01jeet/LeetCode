class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length-1;
        if(nums[s] < nums[e]) return nums[s];
        while(nums[s] > nums[e]){
            int mid = s+(e-s)/2;
            if(nums[s]>nums[mid]) e = mid;
            else s = mid+1;
        }
        return nums[s];
    }
}