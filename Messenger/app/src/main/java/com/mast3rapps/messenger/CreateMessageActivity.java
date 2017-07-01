package com.mast3rapps.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {
    private String message;
    private EditText messagebox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        messagebox = (EditText)findViewById(R.id.messagebox);
    }

    public void onSendMessageToNext(View v) {
        message = messagebox.getText().toString();
        Intent intent = new Intent(this, RecieveMessageActivity.class);
        intent.putExtra(RecieveMessageActivity.STRING_SEND, message);
        startActivity(intent);
    }

    public  void onSendMessageToOthers(View v) {
        message = messagebox.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_SUBJECT, "A message sent from the messanger app!");
        Intent chooseintent = Intent.createChooser(intent, getString(R.string.chooseaction));
        startActivity(chooseintent);
    }
}
