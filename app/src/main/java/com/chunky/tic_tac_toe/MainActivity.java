package com.chunky.tic_tac_toe;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    int activePlayer=0;

    // 0-Yellow, 1-Red

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    // 2 means unplayed

    int[][] winningPositions = { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8,}, {0,4,8}, {2,4,6}};

    boolean gameIsActive = true;

    public void dropIn(View view)
    {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2 &&  gameIsActive) {

            counter.setTranslationY(-1000f);//when user click red image it moves the image 1000f up

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);//replace with yellow image
                gameState[tappedCounter] = 0;
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);//replace with red image
                gameState[tappedCounter] =1;
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(250);//bring yellow image in place of red image
        }

        for(int[] winningPosition : winningPositions)
        {
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&  gameState[winningPosition[0]] == gameState[winningPosition[2]] &&  gameState[winningPosition[0]]!=2)
            {
                if(gameState[winningPosition[0]]==1)
                {
                    TextView text = (TextView) findViewById(R.id.winnerMessage);
                    text.setText("Red has Won");
                    System.out.println("Red");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
                else {
                    TextView text = (TextView) findViewById(R.id.winnerMessage);
                    text.setText("Yellow has Won");
                    System.out.println("Yellow");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                 }
                gameIsActive = false;
            }
            else
            {
                boolean isend = false;

                for(int counters : gameState)
                {
                    if(counters==2)
                        isend = true;
                }
                if(isend==false)
                {
                    TextView winners = (TextView) findViewById(R.id.winnerMessage);

                    winners.setText("It's a Draw!");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);

                }
            }
        }

    }

    public void playButton(View view){

        gameIsActive = true;

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for(int i=0; i<gameState.length; i++) {
            gameState[i] = 2;
        }

        GridLayout gridl = (GridLayout)findViewById(R.id.gridLayout);


        for(int j=0;j< gridl.getChildCount(); j++)
      {
           ((ImageView) gridl.getChildAt(j)).setImageResource(0);
      }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
