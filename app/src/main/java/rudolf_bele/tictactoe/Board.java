/*
Created by Rudolf Bele
 */

package rudolf_bele.tictactoe;


class Board {
    private int[][] board;
    private boolean isCurrentPlayer;

    public void setUpBoard(){
        this.isCurrentPlayer=true;
        this.board= new int[3][3];
    }
    public int[][] getBoard(){
        return this.board;
    }
    public void playRound(int x, int y, int value){
        this.board[x][y]=value;
    }
    public int readCell(int row, int cell){
        return this.board[row][cell];
    }
    public boolean getPlayer(){
        return this.isCurrentPlayer;
    }
    public void setPlayer(boolean player){
        this.isCurrentPlayer=player;
    }
    public boolean lastRound(){
        int roundCheck=0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.board[i][j]==0){
                    roundCheck++;
                }
            }
        }
        return roundCheck < 2;
    }
    public int checkResult(){
        boolean empty = false;
        //preverja ce je izenaceno
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j]==0)
                {
                    empty = true;
                    break;
                }
            }
        }
        if (!empty)
        {
            return 0;

        }
        if (checkWin(1))
        {
            return 1;
        }
        if (checkWin(2))
        {
            return 2;
        }
        return 4;
    }
    private boolean checkWin(int player){
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
        {
            return true;
        }
        else if (board[2][0] == player && board[1][1] == player && board[0][2] == player)
        {
            return true;
        }
        for (int i = 0; i != 3; ++i)
        {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
            {
                return true;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
            {
                return true;

            }
        }

        return false;
    }
    public boolean gameEnded(){
        return checkResult() == 1 || checkResult() == 2 || checkResult() == 0;
    }
}
