package com.example.twoactivityapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMain;
    private TextView textViewMain;

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String SECONDMESSAGE = "com.example.twoactivityapplication.extra.SECONDMESSAGE";

    private ActivityResultLauncher<Intent> secondActivityLauncher;

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

        editTextMain = findViewById(R.id.edittext_main);
        textViewMain = findViewById(R.id.textview_main);

        secondActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                (ActivityResult result) -> {

                    if (result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        String reply = result.getData().getStringExtra(SecondActivity.EXTRA_REPLY);
                        if (reply != null) {
                            textViewMain.setText(reply);
                        }
                    }

                }
        );
    }

    public void launchSecondActivity(View view) {

        Log.d(TAG, "Launching the second activity");

        String textEntered = editTextMain.getText().toString();

        Toast.makeText(this, textEntered, Toast.LENGTH_SHORT).show();

        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
        secondActivityIntent.putExtra(SECONDMESSAGE, textEntered);

        //startActivity(secondActivityIntent);

        secondActivityLauncher.launch(secondActivityIntent);


    }
}

