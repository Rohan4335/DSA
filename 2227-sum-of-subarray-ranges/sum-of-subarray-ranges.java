class Solution {
    static final int mod = 1000000007;

    public long subArrayRanges(int[] nums) {
        int n = nums.length; 
        Stack<Integer> st = new Stack<>();
        int[] leftarr = new int[n];
        int[] rightarr = new int[n];
        //leftmin
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            leftarr[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        st.clear();
        //rightmin
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            rightarr[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }
        st.clear();
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        //leftmax
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            leftmax[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        st.clear();
        //leftmax
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            rightmax[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }
        long minsum = 0;
        for(int i = 0; i<n; i++){
            long leftLen = i - leftarr[i];
            long rightLen = rightarr[i] - i;
            minsum += leftLen*rightLen*nums[i];
        }
        long maxsum = 0;
        for(int i = 0; i<n; i++){
            long leftLen = i - leftmax[i];
            long rightLen = rightmax[i] - i;
            maxsum += leftLen*rightLen*nums[i];
        }
        return maxsum-minsum;
    }
}