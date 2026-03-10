package com.example.implicitintentsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextWebsite;
    Button buttonWebsite;

    EditText editTextLocation;
    Button buttonLocation;

    EditText editTextShareText;
    Button buttonShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextWebsite = findViewById(R.id.edittext_website);
        buttonWebsite = findViewById(R.id.button_website);
        editTextLocation = findViewById(R.id.edittext_location);
        buttonLocation = findViewById(R.id.button_open_location);

        editTextShareText = findViewById(R.id.edittext_sharetext);
        buttonShareText = findViewById(R.id.button_sharetext);
    }

    public void openWebsite(View view) {

        String enteredWebsite = editTextWebsite.getText().toString();

        Uri webpageUri = Uri.parse(enteredWebsite);
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, webpageUri);
        startActivity(websiteIntent);

    }

    public void openLocation(View view) {

        String location = editTextLocation.getText().toString();
        Uri locationUri = Uri.parse("geo:0,0?q=" + location);

        Intent locationIntent = new Intent(Intent.ACTION_VIEW, locationUri);
        startActivity(locationIntent);
    }

    public void shareText(View view) {
        String textToShare = editTextShareText.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(textToShare)
                .startChooser();

    }
}