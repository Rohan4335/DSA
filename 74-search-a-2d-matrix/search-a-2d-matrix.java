class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row: matrix){
            boolean flag = helper(row, target);
            if(flag){
                return true;
            }
        }
            return false;
    }
    public boolean helper(int[] row, int target){
        int low = 0;
        int high = row.length-1;
        while(low <= high){
            int mid = low + (high- low)/2;
            if(row[mid] == target) return true;
            else if(row[mid] > target) high = mid-1;
            else low = mid + 1;
        }
        return false;
    }
}