package com.mast3rapps.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveMessageActivity extends AppCompatActivity {
    public static final String STRING_SEND = "STRING_SEND";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);
        TextView textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        String message = intent.getStringExtra(STRING_SEND);
        textView.setText(message);
    }
}
