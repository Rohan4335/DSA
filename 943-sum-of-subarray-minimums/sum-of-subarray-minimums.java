class Solution {
    static final int mod = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length; 
        Stack<Integer> st = new Stack<>();
        int[] leftarr = new int[n];
        int[] rightarr = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            leftarr[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            rightarr[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }
        st.clear();
        long sum = 0;
        for(int i = 0; i<n; i++){
            long leftLen = i - leftarr[i];
            long rightLen = rightarr[i] - i;
            sum = (sum +(leftLen*rightLen*arr[i])%mod)%mod;
        }
        return (int)sum;
    }
}