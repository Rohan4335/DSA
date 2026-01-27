class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] arr = new int[3];
        int low = 0;
        int count = 0;
        for(int high = 0; high<n; high++){
            char ch = s.charAt(high);
            arr[ch - 'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                count += n - high;
                arr[s.charAt(low) - 'a']--;
                low++;
            }
        }
        return count;
    }
}