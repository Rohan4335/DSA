class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=str.length -1; i >= 0; i--){
            String k = str[i];
            if(k != ""){
                k.trim();
            sb.append(k).append(" ");
            }
            
        }
         return sb.toString().trim();
    }
}