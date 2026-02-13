class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1000000000;
        while(low <=high){
            int mid = low + (high - low)/2;
            if(helper(piles, mid, h)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    public boolean helper(int[] piles, int k, int h){
        long hours = 0;
        for(int pile: piles){
            int div = pile/k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}