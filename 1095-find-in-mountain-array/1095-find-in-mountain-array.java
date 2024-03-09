/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private static int findPeakIndex(MountainArray arr){
        int s=0, e=arr.length()-1;
        while(s<e){
            int m = s+(e-s)/2;
            if(arr.get(m)<arr.get(m+1)) s=m+1;
            else{
                e=m;
            }
        }
        return s;
    }
    private static int srcLeft(MountainArray arr, int target,int s, int e){
        int left=s, right=e;
        while(left<=right){
            int m=left+(right-left)/2;
            if(arr.get(m) == target) return m;
            else if(arr.get(m)<target) left = m+1;
            else right = m-1;
        }
        return -1;
    }
    private static int srcRight(MountainArray arr, int target,int s, int e){
        int left=s, right=e;
        while(left<=right){
            int m=left+(right-left)/2;
            if(arr.get(m) == target) return m;
            else if(arr.get(m)<target) right = m-1;
            else left = m+1;
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);
        int ans1 = srcLeft(mountainArr,target,0,peakIndex);
        if(ans1 != -1) return ans1;
        else return srcRight(mountainArr,target,peakIndex+1,mountainArr.length()-1);
    }
}