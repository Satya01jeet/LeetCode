class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqMap = new int[26];
        int R=0,L=0,maxFreq=0,maxWindow=0;
        for(R=0; R<s.length(); R++){
            char c = s.charAt(R);
            freqMap[c-'A']++;
            maxFreq = maxFreq>freqMap[c-'A']?maxFreq:freqMap[c-'A'];
            if(R-L+1 - maxFreq > k){
                freqMap[s.charAt(L)-'A']--;
                L++;
            }
            else{
                maxWindow = (R-L+1)>maxWindow ? R-L+1:maxWindow;
            }
        } 
        return maxWindow;
    }
}