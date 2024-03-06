class Solution {
    public String minWindow(String s, String t) {
        if(t=="" || t.length()>s.length()) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int i=0,j=0,res=s.length()+1,finI=0,matched=0,n=s.length();
        while(j<n){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) matched++;
                while(matched == map.size()){
                    if(res > j-i+1){
                        res = j-i+1;
                        finI = i;
                    }
                    char deleted = s.charAt(i++);
                    if(map.containsKey(deleted)){
                        if(map.get(deleted)==0) matched--;
                        map.put(deleted,map.get(deleted)+1);
                    }
                }
            }
            j++;
        }
        return res>s.length()?"":s.substring(finI,finI+res);
    }
}