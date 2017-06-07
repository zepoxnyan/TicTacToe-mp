package rudolf_bele.tictactoe;


class AI {
    private int[] pickedXY = new int[2];
    private int idPlayer;
    private int idCPU;
    private int[][] board;

    public AI(int playersShape, int aiShape, int board[][]) {
        this.idPlayer = playersShape;
        this.idCPU = aiShape;
        this.board = board;
    }

    public void makeMove() {
        if (checkCenter()) return;
        if (cpu_winning()) return;
        if (player_winning()) return;
        if (oneInLine()) return;
        randPlay();
    }

    private boolean checkCenter() {
        if (board[1][1] == 0) {
            pickedXY[0] = 1;
            pickedXY[1] = 1;
            return true;
        }
        return false;
    }

    private boolean player_winning() {
        return twoInLine(0, 0, 0, 1, 0, 2, idPlayer)
                || twoInLine(1, 0, 1, 1, 1, 2, idPlayer)
                || twoInLine(2, 0, 2, 1, 2, 2, idPlayer)
                || twoInLine(0, 0, 1, 0, 2, 0, idPlayer)
                || twoInLine(0, 1, 1, 1, 2, 1, idPlayer)
                || twoInLine(0, 2, 1, 2, 2, 2, idPlayer)
                || twoInLine(0, 0, 1, 1, 2, 2, idPlayer)
                || twoInLine(0, 2, 1, 1, 2, 0, idPlayer);
    }

    private boolean cpu_winning() {
        return twoInLine(0, 0, 0, 1, 0, 2, idCPU)
                || twoInLine(1, 0, 1, 1, 1, 2, idCPU)
                || twoInLine(2, 0, 2, 1, 2, 2, idCPU)
                || twoInLine(0, 0, 1, 0, 2, 0, idCPU)
                || twoInLine(0, 1, 1, 1, 2, 1, idCPU)
                || twoInLine(0, 2, 1, 2, 2, 2, idCPU)
                || twoInLine(0, 0, 1, 1, 2, 2, idCPU)
                || twoInLine(0, 2, 1, 1, 2, 0, idCPU);
    }

    private boolean twoInLine(int r1, int c1, int r2, int c2, int r3, int c3, int player) {
        if (board[r1][c1] == player && board[r2][c2] == player && board[r3][c3] == 0) {
            pickedXY[0] = r3;
            pickedXY[1] = c3;
            return true;
        }
        if (board[r1][c1] == player && board[r3][c3] == player && board[r2][c2] == 0) {
            pickedXY[0] = r2;
            pickedXY[1] = c2;
            return true;
        }
        if (board[r2][c2] == player && board[r3][c3] == player && board[r1][c1] == 0) {
            pickedXY[0] = r1;
            pickedXY[1] = c1;
            return true;
        }
        return false;
    }

    private boolean oneInLine() {
        return oneInLine(0, 0, 0, 1, 0, 2)
                || oneInLine(1, 0, 1, 1, 1, 2)
                || oneInLine(2, 0, 2, 1, 2, 2)
                || oneInLine(0, 0, 1, 0, 2, 0)
                || oneInLine(0, 1, 1, 1, 2, 1)
                || oneInLine(0, 2, 1, 2, 2, 2)
                || oneInLine(0, 0, 1, 1, 2, 2)
                || oneInLine(0, 2, 1, 1, 2, 0);
    }

    @SuppressWarnings("WrongConstant")
    private boolean oneInLine(int r1, int c1, int r2, int c2, int r3, int c3) {
        if (board[r1][c1] == idCPU && board[r2][c2] == 0 && board[r3][c3] == 0) {
            pickedXY[0] = r3;
            pickedXY[1] = c3;
            return true;
        }
        if (board[r2][c2] == idCPU && board[r1][c1] == 0 && board[r3][c3]==0) {
            pickedXY[0] = r1;
            pickedXY[1] = c1;
            return true;
        }
        if (board[r3][c3] == idCPU && board[r1][c1] == 0&& board[r2][c2] == 0) {
            pickedXY[0] = r1;
            pickedXY[1] = c1;
            return true;
        }
        return false;
    }

    private void randPlay() {
        while (true) {
            int r = (int) (Math.random() * 3);
            int c = (int) (Math.random() * 3);
            if (board[r][c] == 0) {
                pickedXY[0] = r;
                pickedXY[1] = c;
                break;
            }
        }
    }

    public int getX() {
        return pickedXY[0];
    }

    public int getY() {
        return pickedXY[1];
    }



}
