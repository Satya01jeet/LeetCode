class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        int n = p.length(), size = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        if(n<=size){
            for(int i=0; i<n; i++){
                pArr[p.charAt(i) - 'a']++;
            }
            // first window
            for(int i=0; i<n; i++){
                sArr[s.charAt(i) - 'a']++;
            }
            if(Arrays.equals(pArr,sArr)) list.add(0);
            for(int i=1; i+n-1<size; i++){
                sArr[s.charAt(i-1) - 'a']--;
                sArr[s.charAt(i+n-1) - 'a']++;
                if(Arrays.equals(sArr,pArr)) list.add(i);
            }
        }
        return list;
    }
}