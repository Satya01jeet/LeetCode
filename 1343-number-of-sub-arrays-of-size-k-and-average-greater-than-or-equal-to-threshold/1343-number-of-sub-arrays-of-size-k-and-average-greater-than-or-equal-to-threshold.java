class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // Initial window
        int window = 0, count = 0;
        for(int i=0; i<k; i++){
            window += arr[i];
        }
        if(window/k >= threshold) count++;
        for(int i=1; i+k-1<arr.length; i++){
            window -= arr[i-1];
            window += arr[i+k-1];
            if(window/k >= threshold) count++;
        }
        return count;
    }
}