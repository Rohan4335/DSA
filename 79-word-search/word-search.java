class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                visited[i][j] = true;
                if(board[i][j] == word.charAt(0) && helper(board,visited,word, i, j, 0)){
                    return true;
                }
                visited[i][j]= false;
            }
        }
            return false;
    }
    public boolean helper(char[][] board,boolean[][] visited, String word, int i, int j, int curr){
        if(curr == word.length()-1) return true;
        if(i-1 >= 0 && board[i-1][j] == word.charAt(curr+1) && !visited[i-1][j]){
            visited[i-1][j] = true;
            boolean ans = helper(board, visited, word, i-1, j, curr+1);
            if(ans) return true;
            visited[i-1][j] = false;
        }
        if(j-1 >= 0 && board[i][j-1] == word.charAt(curr+1) && !visited[i][j-1]){
            visited[i][j-1] = true;
            boolean ans = helper(board, visited, word, i, j-1, curr+1);
            if(ans) return true;
            visited[i][j-1] = false;
        }
        if(j+1 < board[0].length && board[i][j+1] == word.charAt(curr+1) && !visited[i][j+1]){
            visited[i][j+1] = true;
            boolean ans = helper(board, visited, word, i, j+1, curr+1);
            if(ans) return true;
            visited[i][j+1] = false;
        }
        if(i+1 < board.length && board[i+1][j] == word.charAt(curr+1) && !visited[i+1][j]){
            visited[i+1][j] = true;
            boolean ans = helper(board, visited, word, i+1, j, curr+1);
            if(ans) return true;
            visited[i+1][j] = false;
        }
        return false;
    }
}