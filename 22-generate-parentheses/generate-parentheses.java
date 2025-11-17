class Solution {
    public List<String> generateParenthesis(int n){
       List<String> res = new ArrayList<>();
       dfs(0,0, "", n, res);
       return res;
    }
    public void dfs(int openP, int closeP, String s, int n, List<String> res){
        if(openP == closeP && openP + closeP == 2*n){
            res.add(s);
            return;
        }
        if(openP < n){
            dfs(openP + 1 , closeP ,s +"(", n,res);
        }
        if(openP > closeP){
            dfs(openP,closeP + 1, s +")", n, res );
        }
    } 
}