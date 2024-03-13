class Solution {
    public int pivotInteger(int n) {
        int sum=0;
        int toSubt = n*(n+1)/2;
        for(int i=1; i<=n; i++){
            sum += i;
            if(sum == toSubt) return i;
            toSubt -= i;
        }
        return -1;
    }
}