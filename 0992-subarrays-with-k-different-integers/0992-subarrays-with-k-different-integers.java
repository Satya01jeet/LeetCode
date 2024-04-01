class Solution {
    private static int atMostKDiff(int[] nums, int k){
        int n = nums.length;
        int i=0, j=0, ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j], 0)+1);
            while(map.size()>k){
                int decrement = map.get(nums[i]);
                map.put(nums[i], --decrement);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            if(map.size() <= k) ans += j-i+1;
            j++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDiff(nums,k)-atMostKDiff(nums,k-1);
    }
}