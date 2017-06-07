/*
Created by Rudolf Bele
 */
package rudolf_bele.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    public void exit_click(View v)
    {
        AlertDialog.Builder popup  = new AlertDialog.Builder(this);

        popup.setMessage(getResources().getString(R.string.exitMsg));
        popup.setTitle(getResources().getString(R.string.btn4));

        popup.setCancelable(true);
        popup.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
        popup.create().show();
    }
    public void about_click(View v)
    {
        Intent myIntent = new Intent(Main.this, About.class);
        Main.this.startActivity(myIntent);
    }
    public void pvp_click(View v)
    {
        Intent myIntent = new Intent(Main.this,VersusPlayer.class);
        Main.this.startActivity(myIntent);
}
    public void pvc_click(View v)
    {
        Intent myIntent = new Intent(Main.this,VersusCPU.class);
        Main.this.startActivity(myIntent);
    }

}
