class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz"); 
        helper(list, digits, 0, new StringBuilder(), map);
        return list;
    }
    void helper(List<String> list, String digits, int idx, StringBuilder comb, Map<Character, String>  map){
        if(comb.length() == digits.length()){
            list.add(comb.toString());
            return;
        }
        String letters = map.get(digits.charAt(idx));
        for(char ch : letters.toCharArray()){
            comb.append(ch);
            helper(list, digits, idx+1, comb, map);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}