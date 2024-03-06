class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        int j=0;
        for(int i=0; i<n; i++){
            if(!q.isEmpty() && q.peekFirst()<i-k+1) q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offer(i);
            if(i>=k-1) res[j++] = nums[q.peekFirst()];
        }
        return res;
    }
}