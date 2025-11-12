class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0){
            return list;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        list.add(firstRow);

        for(int i= 1; i<numRows; i++){
            List<Integer> prevRow = list.get(i-1);
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            for(int j= 1; j<i; j++){
                ans.add(prevRow.get(j-1) + prevRow.get(j));
            }
            ans.add(1);
            list.add(ans);
        }
        return list;
    }
}