class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        Set<Character> set = new HashSet<>();
        int subStringLen = 0;
        int i = 0;
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                subStringLen = subStringLen>set.size()?subStringLen:set.size();
                while(i<size && set.contains(c)){
                    set.remove(s.charAt(i++));
                }
            }
            set.add(c);
        }
        return subStringLen>set.size()?subStringLen:set.size();
    }
}