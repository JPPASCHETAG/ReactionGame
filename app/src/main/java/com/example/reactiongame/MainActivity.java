package com.example.reactiongame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView header;
    TextView text;
    Button  btn;
    ConstraintLayout mainlayout;

    long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainlayout  = findViewById(R.id.layout_activity_main);

        mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            long endTime = System.currentTimeMillis();

            long reactionTime = (endTime - startTime);

            String result  = "Deine Reaktionszeit war: " + reactionTime +"s. Du musst .... trinken!";

            if(startTime != 0) {

                text = text.findViewById(R.id.textView2);
                text.setVisibility(View.VISIBLE);
                text.setText(result);

                System.out.println(reactionTime);
            }else{
                text = text.findViewById(R.id.textView2);
                text.setVisibility(View.VISIBLE);
                text.setText("Du warst zu früh dran. Trink 10.");

                System.out.println("keine Startzeit");
            }
            }
        });
    }


    public void start(View V){

          header = findViewById(R.id.textView);
          text  = findViewById(R.id.textView2);
          btn   = findViewById(R.id.button);
          mainlayout  = findViewById(R.id.layout_activity_main);

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

                int red = Color.parseColor("#FF0000");
                mainlayout.setBackgroundColor(red);

                startTime = System.currentTimeMillis();
            }
        }, delay);
    }




}
