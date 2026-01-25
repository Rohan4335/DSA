class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        int[] arr = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            dq.offerLast(i);
            if(i >= k-1) list.add(nums[dq.peekFirst()]);
        }
        int t=0;
        for(int i: list){
           arr[t] = i;
           t++;
        }
        return arr;
    }
}