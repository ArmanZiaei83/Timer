package com.example.chornometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    public Chronometer chronometer ;
    private long pauseOffSet ;
    boolean runnnig ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chrnometer_0);

    }
    public void  startChronometer (View v) {
        
        if (!runnnig){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            runnnig = true ;
        }
    }

    public void  pauseChronometer (View v) {
        if (runnnig){
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase() ;
            runnnig = false ;
        }
    }

    public void  resetChronometer (View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        runnnig = true; ;
    }
}