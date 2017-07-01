package com.mast3rapps.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    char choice = 'X';
    String  name;
    private TextView welcometxt;
    private EditText nametxt;
    private TextView choosetxt;
    private Button continuebtn;
    private RadioButton xrb;
    private RadioButton orb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);

        welcometxt = (TextView)findViewById(R.id.welcometxt);
        nametxt = (EditText)findViewById(R.id.nametxt);
        choosetxt = (TextView)findViewById(R.id.choosetxt);
        continuebtn = (Button)findViewById(R.id.continuebtn);
        xrb = (RadioButton)findViewById(R.id.xrb);
        orb = (RadioButton)findViewById(R.id.orb);

        welcometxt.setOnClickListener(this);
        nametxt.setOnClickListener(this);
        choosetxt.setOnClickListener(this);
        continuebtn.setOnClickListener(this);
        xrb.setOnClickListener(this);
        orb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xrb:
                choice = 'X';
                break;
            case R.id.orb:
                choice = 'O';
                break;
            case R.id.continuebtn:
                name = nametxt.getText().toString();
                if(name.length() < 3) {
                    Toast.makeText(this,"Sorry! But name must be at least three characters long. Try again.", Toast.LENGTH_LONG).show();
                    nametxt.setText("");
                }

                else {
                    Toast.makeText(this,"Hello, "+name+"! " + "Your preferred symbol is "+choice + "Enjoy your game.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
