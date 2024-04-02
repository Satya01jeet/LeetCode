class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            sb.append(map.get(c));
        }
        if(t.equals(sb.toString())) return true;
        else return false;
    }
}