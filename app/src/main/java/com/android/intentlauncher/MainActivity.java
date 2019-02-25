package com.android.intentlauncher;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText title;
    EditText message;
    CheckBox titleOnly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText) findViewById(R.id.title);
        message = (EditText) findViewById(R.id.message);
        titleOnly = (CheckBox) findViewById(R.id.only_send_title);
    }

    public void pressButton(View view) {
        Intent intent = null;
        Button button = (Button) view;

        if (button.getText().equals(getResources().getString(R.string.launch_camera))) {
            intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        } else {
            if (button.getText().equals(getResources().getString(R.string.send_email))) {
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
            } else {
                intent = new Intent(this, SecondActivity.class);
            }
            intent.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
            if (!titleOnly.isChecked()) {
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
            }
        }

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
