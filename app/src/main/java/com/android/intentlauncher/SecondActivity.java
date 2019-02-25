package com.android.intentlauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.show_message);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra(Intent.EXTRA_SUBJECT));
        textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
    }
}
