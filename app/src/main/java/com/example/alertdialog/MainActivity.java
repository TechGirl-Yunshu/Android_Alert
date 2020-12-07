package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.internal.ParcelableSparseArray;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showDialogID);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show alert
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                //set things up - setup title
                alertDialog.setTitle(R.string.title);
                alertDialog.setIcon(android.R.drawable.btn_star);

                //setup message
                alertDialog.setMessage(R.string.mainMessage);

                //setup cancelable
                alertDialog.setCancelable(false);

                //set positive button
                alertDialog.setPositiveButton((R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Exit window
                        MainActivity.this.finish();
                    }
                });

                alertDialog.setNegativeButton((R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                //create a real dialog
                AlertDialog dialog = alertDialog.create();

                //show dialog
                dialog.show();
            }
        });
    }
}