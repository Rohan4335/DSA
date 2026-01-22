class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];
        for(int j = 0; j<m; j++){
            int sum = 0;
            for(int i = 0; i<n; i++){
                sum = sum + (matrix[i][j] - '0'); 
                if(matrix[i][j] == '0') sum = 0;
                res[i][j] = sum;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, histogram(res[i]));
        }
        return ans;
    }
    public int histogram(int[] arr){
        int n = arr.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Stack<Integer> st = new Stack<>();
        // left min
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            leftMin[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        st.clear();
        // right min
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            rightMin[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }
        st.clear();
        int sum = 0; 
        for(int i=0; i<n; i++){
            
            sum = Math.max(sum,arr[i]*(rightMin[i] -leftMin[i] - 1));
        }
        return sum;
    }
}