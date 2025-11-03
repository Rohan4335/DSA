class Solution {
    public String longestPalindrome(String s) {
        String LPS = "";
        if(s.length() <= 1) return s;
        for(int i = 0; i<s.length()-1; i++){
            int low = i;
            int high = i;
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == s.length()){
                    break;
                }
            }
                String palindrome = s.substring(low+1, high);
                if(palindrome.length()> LPS.length()){
                    LPS = palindrome;
                }   
        }
        for(int i = 1; i<s.length(); i++){
            int low = i-1;
            int high = i;
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == s.length()){
                    break;
                }
            }
                String palindrome = s.substring(low+1, high);
                if(palindrome.length()> LPS.length()){
                    LPS = palindrome;
                }   
        }
        return LPS;
    }
}   