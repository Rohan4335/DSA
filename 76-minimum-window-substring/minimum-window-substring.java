class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size();
        int startIndex = -1;
        int start = 0; 
        int end= 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();
        while(end < n){
            //expansion phase
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0){
                    count--;
                }
            }
            //shrinking phase
            while(count == 0){
                int len = end - start + 1;
                if(len < minLen){
                    minLen = len;
                    startIndex = start;
                }
                ch = s.charAt(start);
                if(map.containsKey(ch)){
                   map.put(ch,map.get(ch)+1);
                   if(map.get(ch) > 0){
                    count++;
                   }
                }
                start++;
            }
            end++;
        }
        if(startIndex == -1){
            return "";
        }
        return s.substring(startIndex, startIndex+minLen);
    }
}