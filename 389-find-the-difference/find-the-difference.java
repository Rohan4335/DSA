class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        char ans = ' ';
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i),map.get(s.charAt(i)) -1);
        }
        for(char k: map.keySet()){
            if(map.get(k) != 0){
                ans = k;
            }
        }
        return ans;
        
    }
}