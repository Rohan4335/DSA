class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        char ans = ' ';
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(char c: s.toCharArray()){
            map.put(c, map.get(c) -1);
            if(map.get(c) == 0){
                map.remove(c);
            } 
        }
        return (char) map.keySet().toArray()[0];
        
    }
}