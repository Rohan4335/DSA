class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Arrays.sort(hand);
        for(int i = 0; i<n; i++){
            if(hand[i] >=0){
                if(!isPossible(hand, groupSize, i, n)){
                    return false; 
                }
            }
        }
        return true;
    }
    public boolean isPossible(int[] hand, int groupSize, int i , int n){
        int f = hand[i] + 1;
        hand[i] = -1;
        int cnt = 1;
        i += 1;
        while(i<n && cnt < groupSize){
            if(hand[i] == f){
                f = hand[i] + 1;
                hand[i] = -1;
                cnt++;
            }
            i++;
        }
        if(cnt != groupSize) return false;
        else return true;
    }
}