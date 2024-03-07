class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        @SuppressWarnings("unchecked")
        List<Integer>[] a = new ArrayList[nums.length+1];
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            int freq = map.get(i);
            if(a[freq] == null) a[freq] = new ArrayList<>();
            a[freq].add(i);
        }
        int res[] = new int[k];
        int j=0;
        for(int i=a.length-1; i>=0 && j<k; i--){
            if(a[i] != null){
                for(int elem : a[i]) res[j++] = elem;
            }
        }
        return res;
    }
}