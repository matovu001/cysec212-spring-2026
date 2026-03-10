package com.example.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonRoll;
    private ImageView imageViewRoll;
    private TextView textViewRoll;
    private int rollResult = 0;

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

        buttonRoll = findViewById(R.id.button_roll);
        textViewRoll = findViewById(R.id.textview_roll);
        imageViewRoll = findViewById(R.id.imageview_dice);

        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked Button Roll", Toast.LENGTH_LONG).show();

                rollResult = new Random().nextInt(6) + 1;

                switch (rollResult) {
                    case 1:
                        imageViewRoll.setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        imageViewRoll.setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        imageViewRoll.setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        imageViewRoll.setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        imageViewRoll.setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        imageViewRoll.setImageResource(R.drawable.dice_6);
                        break;
                    default:
                        imageViewRoll.setImageResource(R.drawable.empty_dice);

                }

                textViewRoll.setText(Integer.toString(rollResult));
            }
        });

    }
}