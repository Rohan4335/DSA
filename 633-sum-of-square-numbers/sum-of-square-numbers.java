class Solution {
    public boolean judgeSquareSum(int c) {
        long s = 0; 
        long end = (long)Math.sqrt(c);
        while(s<= end){
            long res= s*s + end*end;
            if(res == c) return true;
            if(res > c) end--;
            else s++;
        }
        return false;
    }
}