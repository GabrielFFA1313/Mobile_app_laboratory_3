package com.example.activity_3_araneta;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView show, total;
    ImageView diceImage;
    ImageView bdiceImage;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.show);
        total = findViewById(R.id.total);
        diceImage = findViewById(R.id.diceImage);
        bdiceImage = findViewById(R.id.diceImage2);
        button = findViewById(R.id.button);

        myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();

                //  First dice animation
                diceImage.setImageResource(R.drawable.dice_roll);
                AnimationDrawable diceAnimation = (AnimationDrawable) diceImage.getDrawable();
                diceAnimation.start();

                // Second dice animation
                bdiceImage.setImageResource(R.drawable.bdice_roll);
                AnimationDrawable diceAnimation2 = (AnimationDrawable) bdiceImage.getDrawable();
                diceAnimation2.start();

                // Delay final results so animation can play
                diceImage.postDelayed(() -> {
                    int rollResult1 = rand.nextInt(6) + 1;
                    int rollResult2 = rand.nextInt(6) + 1;

                    // Update text with both dice results
                    show.setText("Rolled: " + rollResult1 + " and " + rollResult2);
                    total.setText("Total: " + (rollResult1 + rollResult2));

                    // First dice result
                    switch (rollResult1) {
                        case 1: diceImage.setImageResource(R.drawable.dice1); break;
                        case 2: diceImage.setImageResource(R.drawable.dice2); break;
                        case 3: diceImage.setImageResource(R.drawable.dice3); break;
                        case 4: diceImage.setImageResource(R.drawable.dice4); break;
                        case 5: diceImage.setImageResource(R.drawable.dice5); break;
                        case 6: diceImage.setImageResource(R.drawable.dice6); break;
                    }

                    // Second dice result
                    switch (rollResult2) {
                        case 1: bdiceImage.setImageResource(R.drawable.dicer1); break;
                        case 2: bdiceImage.setImageResource(R.drawable.dicer2); break;
                        case 3: bdiceImage.setImageResource(R.drawable.dicer3); break;
                        case 4: bdiceImage.setImageResource(R.drawable.dicer4); break;
                        case 5: bdiceImage.setImageResource(R.drawable.dicer5); break;
                        case 6: bdiceImage.setImageResource(R.drawable.dicer6); break;
                    }
                }, 600); // wait until animations finish
            }
        });
    }
}
