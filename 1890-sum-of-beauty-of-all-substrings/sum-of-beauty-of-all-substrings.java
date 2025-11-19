class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for(int i=0; i<n; i++) {
            int[] freq  = new int[26];
            for(int j=i; j<n; j++) {
                freq[s.charAt(j) - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer. MAX_VALUE;
                
                for(int f : freq){
                    if(f>0){
                        max = Math.max(f, max);
                        min = Math.min(f, min);
                    }
                }
                sum += (max- min);
            }
        }

        return sum;
    
    }
} 