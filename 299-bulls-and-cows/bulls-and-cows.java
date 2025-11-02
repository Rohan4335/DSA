class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character,Integer> sec = new HashMap<>();
        Map<Character,Integer> gue = new HashMap<>();// Peh
        for(int i= 0; i<secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s==g){
                bulls++;
            }
            else{
                sec.put(s, sec.getOrDefault(s,0)+1);
                gue.put(g, gue.getOrDefault(g,0)+1);
            }
        }
        for(char c : sec.keySet()){
            if(gue.containsKey(c)){
                cows += Math.min(sec.get(c),gue.get(c));
            }
        }
        return bulls + "A"+cows+"B";
    }
}