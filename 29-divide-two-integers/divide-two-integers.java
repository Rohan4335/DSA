class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        int ans = 0;
        boolean negative = (dividend < 0)^(divisor < 0);
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        while(n >= d){
            int cnt = 0;
            while(n >= d<<(cnt+1)){
                cnt++;
            }
            ans += (1<<cnt);
            n -= (d<<cnt);
        }
        return negative ? -ans: ans;
    }
}