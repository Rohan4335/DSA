class Solution {



    public void myfun(int[] nums,int i,List<Integer> li,List<List<Integer>> ans){

        if(i == nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[i]);
        myfun(nums,i+1,li,ans);

        li.remove(li.size()-1);
      
        myfun(nums,i+1,li,ans);
    }



    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> li = new ArrayList<>();

        myfun(nums,0,li,ans);

        return ans;
        
    }
}