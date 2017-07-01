package com.mast3rapps.widgetexploration;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        // grab all the references
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        RadioButton  rbLondon = (RadioButton)findViewById(R.id.radioButtonLondon);
        RadioButton  rbBeijing = (RadioButton)findViewById(R.id.radioButtonBeijing);
        RadioButton  rbNewYork = (RadioButton)findViewById(R.id.radioButtonNewYork);
        final EditText editText = (EditText)findViewById(R.id.editText);
        final Button button = (Button)findViewById(R.id.button);
        final TextClock tclock = (TextClock)findViewById(R.id.textClock);
        final CheckBox cbTransparency = (CheckBox) findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize = (CheckBox) findViewById(R.id.checkBoxReSize);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        final WebView webView = (WebView) findViewById(R.id.webView);

        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbTransparency.isChecked()) {
                    imageView.setAlpha(0.1f);
                }
                else {
                    imageView.setAlpha(1f);
                }
            }
        });

        cbTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbTint.isChecked()) {
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                }
                else {
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                }
            }
        });

        cbReSize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbReSize.isChecked()) {
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                }
                else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                switch (rb.getId()) {
                    case R.id.radioButtonLondon:
                        tclock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonBeijing:
                        tclock.setTimeZone("CST6CDT");
                        break;
                    case R.id.radioButtonNewYork:
                        tclock.setTimeZone("America/New_York");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText(editText.getText().toString());
            }
        });

        webView.loadUrl("http://www.cs.yale.edu/homes/tap/Files/hopper-story.html");
        webView.setVisibility(View.INVISIBLE);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    webView.setVisibility(View.VISIBLE);
                }
                else {
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
