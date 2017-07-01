package com.gamecodeschool.practise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int value = 0;
    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout);
        Toast.makeText(this, "OnCreate Method", Toast.LENGTH_LONG).show();

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnTake = (Button)findViewById(R.id.btnTake);
        btnGrow = (Button)findViewById(R.id.btnGrow);
        btnShrink = (Button)findViewById(R.id.btnShrink);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnHide = (Button)findViewById(R.id.btnHide);
        txtValue = (TextView) findViewById(R.id.txtValue);

        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        txtValue.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHide.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart Method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume Method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPaus Method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(this,"OnStop Method", Toast.LENGTH_LONG).show();
    }

    @Override
    public  void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy Method", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        float size;
        switch (v.getId()) {
            case R.id.btnAdd:
                value++;
                txtValue.setText(""+value);
                break;
            case R.id.btnTake:
                value--;
                txtValue.setText(""+value);
                break;
            case R.id.btnReset:
                value = 0;
                txtValue.setText(""+value);
                break;
            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);
                break;
            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);
                break;
            case R.id.btnHide:
                if(txtValue.getVisibility() == View.VISIBLE) {
                    txtValue.setVisibility(View.INVISIBLE);
                    btnHide.setText("Show");
                }

                else if(txtValue.getVisibility() == View.INVISIBLE) {
                    txtValue.setVisibility(View.VISIBLE);
                    btnHide.setText("Hide");
                }
                break;
        }
    }
}
