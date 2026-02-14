class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxEle = -1;
        int ans = 0;
        int sum = 0;
        for(int k: weights){
            sum +=k;
            maxEle = Math.max(maxEle, k);
        }
        int low = maxEle;
        int high = sum;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canCarry(weights, mid, days)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean canCarry(int[] weights, int maxWeight, int days){
        int d = 1;
        int sum = 0;
        for(int i=0; i<weights.length; i++){
            if(sum + weights[i] > maxWeight){
                d++;
                sum =0;
            }
            sum += weights[i];
        }
        return d<=days;
    }
}