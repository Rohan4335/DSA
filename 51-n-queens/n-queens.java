class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        nQueens(ans, board , n, 0);
        return ans;
    }
    public void nQueens(List<List<String>> ans, char[][] board, int n, int row){
        if(row == n){
            saveBoard(board, ans);
            return;
        }
        for(int j=0; j<n; j++){
            if(isSafe(board, row, j, n)){
                board[row][j] = 'Q';
                nQueens(ans, board, n ,row+1);
                board[row][j] = '.';
            }
        }
    }
    public void saveBoard(char[][] board, List<List<String>> ans){
        List<String> newBoard = new ArrayList<>();
        for(int i=0; i< board.length; i++){
            String row = "";
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == 'Q'){
                    row += 'Q';
                }else{
                    row += '.';
                }
            }
                newBoard.add(row);
        }
        ans.add(newBoard);
    }

    boolean isSafe(char[][] board, int row, int col, int n){
        for(int j= 0; j<n; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }
        for(int i= 0; i<n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j<n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}