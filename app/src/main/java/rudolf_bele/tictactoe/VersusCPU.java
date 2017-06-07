package rudolf_bele.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VersusCPU extends AppCompatActivity {
    Board Miza = new Board();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        Miza.setUpBoard();
        TextView poteza = (TextView) findViewById(R.id.whosPlayin);
        poteza.setText(getResources().getString(R.string.p1turn));
    }

    public void makeMove(View v){
        AI ttt_master = new AI(1,2,Miza.getBoard());
        int x = 0;
        int y = 0;
        int id = v.getId();
        switch(id)
        {
            case R.id.r1c1: break;
            case R.id.r1c2: x = 0; y = 1;break;
            case R.id.r1c3: x = 0; y = 2;break;
            case R.id.r2c1: x = 1; y = 0;break;
            case R.id.r2c2: x = 1; y = 1;break;
            case R.id.r2c3: x = 1; y = 2;break;
            case R.id.r3c1: x = 2; y = 0;break;
            case R.id.r3c2: x = 2; y = 1;break;
            case R.id.r3c3: x = 2; y = 2;break;
        }
        if(Miza.readCell(x,y) != 0)
        {
            AlertDialog.Builder popup  = new AlertDialog.Builder(this);
            popup.setMessage(getResources().getString(R.string.errorMsg));
            popup.setTitle(getResources().getString(R.string.errorT));
            popup.setCancelable(true);
            popup.create().show();
            return;
        }
        Button btn = (Button) findViewById(id);
        TextView poteza = (TextView) findViewById(R.id.whosPlayin);
        if(Miza.getPlayer())
        {
            Miza.playRound(x,y,1);
            Miza.setPlayer(false);
            switchImage(x,y,1);
            poteza.setText(getResources().getString(R.string.cputurn));

        }
        if(!Miza.lastRound()) {
            ttt_master.makeMove();
            y = ttt_master.getY();
            x = ttt_master.getX();
            Miza.playRound(x, y, 2);
            Miza.setPlayer(true);
            switchImage(x, y, 2);
            poteza.setText(getResources().getString(R.string.p1turn));
        }
        endGame();
    }
    private void switchImage(int x, int y, int player){

        Button btnAi;
        if(player==1) {
            if (x == 0) {
                if (y == 0) {
                    btnAi = (Button) findViewById(R.id.r1c1);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
                if (y == 1) {
                    btnAi = (Button) findViewById(R.id.r1c2);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
                if (y == 2) {
                    btnAi = (Button) findViewById(R.id.r1c3);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
            }
            if (x == 1) {
                if (y == 0) {
                    btnAi = (Button) findViewById(R.id.r2c1);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
                if (y == 1) {
                    btnAi = (Button) findViewById(R.id.r2c2);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
                if (y == 2) {
                    btnAi = (Button) findViewById(R.id.r2c3);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
            }
            if (x == 2) {
                if (y == 0) {
                    btnAi = (Button) findViewById(R.id.r3c1);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
                if (y == 1) {
                    btnAi = (Button) findViewById(R.id.r3c2);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
                if (y == 2) {
                    btnAi = (Button) findViewById(R.id.r3c3);
                    btnAi.setBackgroundResource(R.drawable.x);
                }
            }
        }
        if(player==2) {
            if (x == 0) {
                if (y == 0) {
                    btnAi = (Button) findViewById(R.id.r1c1);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
                if (y == 1) {
                    btnAi = (Button) findViewById(R.id.r1c2);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
                if (y == 2) {
                    btnAi = (Button) findViewById(R.id.r1c3);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
            }
            if (x == 1) {
                if (y == 0) {
                    btnAi = (Button) findViewById(R.id.r2c1);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
                if (y == 1) {
                    btnAi = (Button) findViewById(R.id.r2c2);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
                if (y == 2) {
                    btnAi = (Button) findViewById(R.id.r2c3);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
            }
            if (x == 2) {
                if (y == 0) {
                    btnAi = (Button) findViewById(R.id.r3c1);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
                if (y == 1) {
                    btnAi = (Button) findViewById(R.id.r3c2);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
                if (y == 2) {
                    btnAi = (Button) findViewById(R.id.r3c3);
                    btnAi.setBackgroundResource(R.drawable.o);
                }
            }
        }
    }
    private void endGame() {

        if(Miza.gameEnded()) {
            AlertDialog.Builder popup  = new AlertDialog.Builder(this);
            int result=Miza.checkResult();
            popup.setTitle(getResources().getString(R.string.alertTitle));
            if (result == 0) {
                popup.setMessage(getResources().getString(R.string.draw));
            }
            if (result == 2) {
                popup.setMessage(getResources().getString(R.string.player2) +" " + getResources().getString(R.string.win));
            }
            if (result == 1) {
                popup.setMessage(getResources().getString(R.string.player1) +" " + getResources().getString(R.string.win));
            }
            popup.setCancelable(false);
            popup.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    });
            popup.create().show();
        }
    }
}
