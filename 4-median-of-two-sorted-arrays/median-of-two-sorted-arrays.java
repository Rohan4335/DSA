class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length; 
        int m = nums2.length;
        int low = 0, high = nums1.length;
        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (n+m+1)/2 - partitionX;
            int l1 = partitionX == 0? Integer.MIN_VALUE: nums1[partitionX-1];
            int l2 = partitionY == 0? Integer.MIN_VALUE: nums2[partitionY-1];

            int r1 = partitionX >= n ? Integer.MAX_VALUE: nums1[partitionX];
            int r2 = partitionY >= m ? Integer.MAX_VALUE: nums2[partitionY];

            if(l1 <= r2 && l2 <= r1){
                if((n+m) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }else{
                    return (double)Math.max(l1, l2);
                }
            }else if(l1 > r2){
                high = partitionX - 1;
            }else{
                low = partitionX+1;
            }
        }
        return 0.0;
    }
}