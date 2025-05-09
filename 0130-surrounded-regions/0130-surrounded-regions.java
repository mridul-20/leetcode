class Solution {
    private boolean isSafe(int r , int c ,int n , int m){
        return (r>=0 && r <n && c >=0 && c < m);
    }

    private void floodfill(int r , int c , int n ,int m , char[][]board){
        board[r][c] = 'v';
        int[][] dir = {{-1,0} , {1,0} , {0,-1} , {0,1}};

        for(int k =0 ; k<4; k++){
            int nrow = r + dir[k][0];
            int ncol = c + dir[k][1];

            if(isSafe(nrow , ncol , n , m) && board[nrow][ncol] == 'O'){
                floodfill(nrow, ncol ,n ,m ,board);
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // step1 - border and connected o's flip it to v
        for(int j =0 ; j < m ; j++){
            if(board[0][j] == 'O') floodfill(0 , j , n , m , board);
            if(board[n-1][j] == 'O') floodfill(n-1 , j , n , m , board);
        }
        for(int i =0 ; i < n ; i++){
            if(board[i][0] == 'O') floodfill(i , 0 , n ,m ,board);
            if(board[i][m-1] == 'O') floodfill(i , m-1 , n , m, board);
        }

        // step2 - flip remaining o's to x
        for(int  i =0 ;i < n ; i++){
            for(int j = 0; j< m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        // step3 - flip all v's to o
        for(int i = 0 ;i <n ; i++){
            for(int j =0 ;j <m ; j++){
                if(board[i][j] == 'v'){
                    board[i][j] = 'O' ; 
                }
            }
        }
    }
}