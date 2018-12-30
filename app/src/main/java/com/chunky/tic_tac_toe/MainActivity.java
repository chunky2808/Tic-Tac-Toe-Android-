package com.chunky.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public void dropIn(View view)
    {
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1000f);
        counter.setImageResource(R.drawable.yellow);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
