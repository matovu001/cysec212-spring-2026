package com.example.twoactivityapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextSecond;
    private TextView textViewSecond;
    private Button buttonSecond;

    public static final String EXTRA_REPLY = "com.example.twoactivityapplication.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextSecond = findViewById(R.id.edittext_second);
        textViewSecond = findViewById(R.id.textview_second);
        buttonSecond = findViewById(R.id.button_reply);

        Intent secondIntent = getIntent();
        String receivedText = secondIntent.getStringExtra(MainActivity.SECONDMESSAGE);
        textViewSecond.setText(receivedText);

        setResult(RESULT_CANCELED);
    }

    public void sendReply(View view) {

        String reply = editTextSecond.getText().toString().trim();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);

        setResult(RESULT_OK, replyIntent);
        finish();

    }
}