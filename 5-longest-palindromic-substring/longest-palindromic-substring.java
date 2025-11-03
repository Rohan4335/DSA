class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        int n = s.length();
        if(s.length() <= 1) return s;
        //odd length palindrome
        for(int i=0; i<n; i++){
            int low = i;
            int high =i;
            while(low <= high && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                if(low <0 || high>=n){
                    break;
                }
            }
            String palindrome = s.substring(low+1,high);
            if(palindrome.length() >= lps.length()){
                lps = palindrome;
            }
        }
        for(int i=0; i<n; i++){
            int low = i;
            int high =i+1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            String palindrome = s.substring(low+1,high);
            if(palindrome.length() >= lps.length()){
                lps = palindrome;
            }
        }
        return lps;
    }
}   