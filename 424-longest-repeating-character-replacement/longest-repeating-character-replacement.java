class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] arr = new int[26];
        int max = 0;
        int maxfreq = 0;
        int low = 0;
        for(int high = 0; high<n; high++){
            arr[s.charAt(high) - 'A']++;
            maxfreq = Math.max(maxfreq, arr[s.charAt(high) - 'A']);
            int window_size = high - low + 1;
            if(window_size - maxfreq > k){
                arr[s.charAt(low) - 'A']--;
                low++;
            }
            window_size = high - low+1;
            max = Math.max(max, window_size);
        }
        return max;
    }
}