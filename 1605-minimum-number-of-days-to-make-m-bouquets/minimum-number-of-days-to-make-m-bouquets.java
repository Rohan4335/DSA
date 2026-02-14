class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = (int)1e9;
        if((long)m*k > bloomDay.length) return -1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(bloomDay, m, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] bloomDay, int m, int k, int day){
        int count =0;
        int total = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;
            }else{
                count = 0;
            }
            if(count == k){
                total++;
                count =0;
            }
            if(total >= m){
                return true;
            }
        }
        return false;
    }
}