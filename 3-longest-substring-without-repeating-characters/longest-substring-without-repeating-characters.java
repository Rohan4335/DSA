class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map= new HashMap<>();
        int low = 0; 
        int max = 0;
        for(int high = 0; high< n; high++){
            char ch = s.charAt(high);
            if(map.containsKey(ch)){
                low = Math.max(low, map.get(ch)+1);
            }
            map.put(ch, high);
            max = Math.max(max, high - low +1);
        }
        return max;
    }
}