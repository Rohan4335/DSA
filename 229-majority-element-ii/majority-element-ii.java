class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        for(Map.Entry<Integer, Integer> x : map.entrySet()){
            if(x.getValue() > nums.length/3){
                list.add(x.getKey());
            }
        }
        return list;
    }
}