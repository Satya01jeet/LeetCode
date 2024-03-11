class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:order.toCharArray()){
            if(map.containsKey(c)){
                while(map.get(c)>0){
                    sb.append(c);
                    map.put(c,map.getOrDefault(c,0)-1);
                }
            }
        }
        for(char c:map.keySet()){
            while(map.get(c)>0){
                sb.append(c);
                map.put(c,map.getOrDefault(c,0)-1);
            }
        }
        return sb.toString();
    }
}