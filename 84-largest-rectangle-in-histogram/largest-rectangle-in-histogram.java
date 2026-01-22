class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] leftarr = new int[n];
        int[] rightarr = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            leftarr[i] = (st.isEmpty())? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                st.pop();
            }
            rightarr[i] = (st.isEmpty())? n : st.peek();
            st.push(i);
        }
        long area = 0;
        for(int i =0 ; i<n; i++){
            area = Math.max(area, (rightarr[i] - leftarr[i] - 1)*heights[i]);
         }
         return (int)area;
    }
}