class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == 0) count++;
        }
        int len = n + count;
        for(int i=n-1, j = len -1; i<j; i--, j--){
            if(arr[i] != 0){
                if(j < n) arr[j] = arr[i];
            }else{
                if(j<n) arr[j] = arr[i];
                j--;
                if(j<n) arr[j] = arr[i];
            }
        }
        
    }
}