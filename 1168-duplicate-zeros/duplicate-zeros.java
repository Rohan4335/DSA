class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i=0;
        while(i < n){
            if(arr[i] == 0){
                for(int j = n-1; j>i; j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }
            i++;
        }
    }
}