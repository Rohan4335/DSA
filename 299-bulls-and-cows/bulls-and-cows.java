class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        StringBuilder secret1 = new StringBuilder(secret);
        StringBuilder guess1 = new StringBuilder(guess);
        for(int i =0; i<secret1.length(); i++){
            if(secret1.charAt(i) == guess1.charAt(i)){
                bulls++;
            }
        }
        for(int i= 0; i<secret1.length(); i++){
            char ch = secret1.charAt(i);
            if(secret1.charAt(i) != guess1.charAt(i)){
                for(int j=0; j<guess1.length(); j++){
                    if(secret1.charAt(j) != guess1.charAt(j)){
                    if(ch == guess1.charAt(j)){
                        cows++;
                        guess1.setCharAt(j, ' ');
                        break;
                    }
                    }
                }
            }
        }
        Integer.toString(bulls);
        Integer.toString(cows);
        String ans = bulls + "" + "A" + cows + "B";
        return ans;

    }
}