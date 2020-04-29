package com.reaction.reactiongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView header;
    TextView text;
    Button  btn;
    ConstraintLayout mainlayout;
    ImageView beer_image;


    long startTime = 0;
    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainlayout  = findViewById(R.id.layout_activity_main);
        mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            long endTime = System.currentTimeMillis();
            double reactionTime = ((double)endTime - (double)startTime) / 1000;

            if(isClicked){
                return;
            }else{
                mainlayout  = findViewById(R.id.layout_activity_main);

                if(startTime != 0) {
                    //Wenn eine Reaktionszeit berechnet werden kann
                    String result;

                    int color = Color.parseColor("#f4cb34");
                    mainlayout.setBackgroundColor(color);

                    text = text.findViewById(R.id.textView2);
                    text.setVisibility(View.VISIBLE);
                    if(reactionTime > 0.3) {
                        result = "Deine Reaktionszeit war: " + reactionTime + "s. \n Du musst " + Math.round((reactionTime-0.3) / 0.1) + " trinken!";
                    }else{
                        result = "Deine Reaktionszeit war: " + reactionTime + "s. \n Du darfst 5 verteilen.";
                    }
                    text.setText(result);

                    beer_image = findViewById(R.id.prost);
                    beer_image.setVisibility(View.VISIBLE);

                    btn = btn.findViewById(R.id.button);
                    btn.setText("Neuer Versuch");
                    btn.setVisibility(View.VISIBLE);

                    //Zurücksetzen und andere Clicks abfangen
                    isClicked = true;
                    startTime = 0;
                }else{

                    int red = Color.parseColor("#9e3030");
                    mainlayout.setBackgroundColor(red);

                    text = text.findViewById(R.id.textView2);
                    text.setVisibility(View.VISIBLE);
                    text.setText("Du warst zu früh dran. Trink 10.");

                    beer_image = findViewById(R.id.prost);
                    beer_image.setVisibility(View.VISIBLE);

                    btn = btn.findViewById(R.id.button);
                    btn.setText("Neuer Versuch");
                    btn.setVisibility(View.VISIBLE);

                    //Zurücksetzen und andere Clicks abfangen
                    isClicked = true;
                    startTime = 0;
                }
            }

            }
        });
    }


    public void start(View V){
        isClicked = false;
        mainlayout  = findViewById(R.id.layout_activity_main);

        int color = Color.parseColor("#f4cb34");
        mainlayout.setBackgroundColor(color);

        beer_image = findViewById(R.id.prost);
        beer_image.setVisibility(View.INVISIBLE);

        header = findViewById(R.id.textView);
        text  = findViewById(R.id.textView2);
        btn   = findViewById(R.id.button);


        header.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);

        double dblRnd =  (Math.random() * 1500) + 500;
        int delay = (int) dblRnd;
        delay = delay + 800;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

        int red = Color.parseColor("#9e3030");
        mainlayout.setBackgroundColor(red);

        startTime = System.currentTimeMillis();
            }
        }, delay);
    }




}
