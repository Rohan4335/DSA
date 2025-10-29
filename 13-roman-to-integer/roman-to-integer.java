class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char key1 = s.charAt(i);
            if(key1 == 'I'){
                map.put(key1, 1);
            }
            if(key1 == 'V'){
                map.put(key1, 5);
            }
            if(key1 == 'X'){
                map.put(key1, 10);
            }
            if(key1 == 'L'){
                map.put(key1, 50);
            }
            if(key1 == 'C'){
                map.put(key1, 100);
            }
            if(key1 == 'D'){
                map.put(key1, 500);
            }
            if(key1 == 'M'){
                map.put(key1, 1000);
            }
        }
        for(int i=0; i<s.length()-1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans = ans - map.get(s.charAt(i));
            }else{
                ans = ans + map.get(s.charAt(i));
            }
        }
        return ans + map.get(s.charAt(s.length()-1));
    }
}