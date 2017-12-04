
package edu.cpp.student.concentration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private int numTries = 0;
    private int points = 0;
    private int numTiles;
    private int tilesRemaining;
    private boolean firstTime = true;
    boolean quit = false;

    private List<String> guesses = new ArrayList<>();
    private Button tryAgain;
    private Button newGame;
    private Button endGame;
    private GridLayout gv;
    private ArrayAdapter<String> gridViewArrayAdapter;
    private List<String> animalList = new ArrayList<>();
    private List<Button> buttonList = new ArrayList<>();
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b10;
    private Button b11;
    private Button b12;
    private Button b13;
    private Button b14;
    private Button b15;
    private Button b16;
    private Button b17;
    private Button b18;
    private Button b19;
    private Button b20;
    private Button[]  buttonArray;
    String[] AnimalListRestore;

    private TextView Score;

    private  final String[] fullAnimalList = new String[]
    {
            "CAT",
            "BIRD",
            "DOG",
            "BEAR",
            "SNAKE",
            "LION",
            "DEER",
            "WOLF",
            "TIGER",
            "HORSE"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalList = Arrays.asList(fullAnimalList);
        Collections.shuffle(animalList);

        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);
        Button b4 = (Button)findViewById(R.id.button4);
        Button b5 = (Button)findViewById(R.id.button5);
        Button b6 = (Button)findViewById(R.id.button6);
        Button b7 = (Button)findViewById(R.id.button7);
        Button b8 = (Button)findViewById(R.id.button8);
        Button b9 = (Button)findViewById(R.id.button9);
        Button b10 = (Button)findViewById(R.id.button10);
        Button b11 = (Button)findViewById(R.id.button11);
        Button b12 = (Button)findViewById(R.id.button12);
        Button b13 = (Button)findViewById(R.id.button13);
        Button b14 = (Button)findViewById(R.id.button14);
        Button b15 = (Button)findViewById(R.id.button15);
        Button b16 = (Button)findViewById(R.id.button16);
        Button b17 = (Button)findViewById(R.id.button17);
        Button b18 = (Button)findViewById(R.id.button18);
        Button b19 = (Button)findViewById(R.id.button19);
        Button b20 = (Button)findViewById(R.id.button20);
        buttonArray = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20};
        Score = (TextView) findViewById(R.id.XMLpoints);
        for(int i = 0; i < 20; i ++)
        {
            buttonArray[i].setOnClickListener(myListener);
            buttonArray[i].setVisibility(View.INVISIBLE);
            buttonArray[i].setBackgroundResource(R.drawable.buttonshape);
            buttonArray[i].setTextColor(Color.parseColor("#4F4F4F"));
        }

        tryAgain = (Button) findViewById(R.id.try_again);
        newGame = (Button) findViewById(R.id.new_game);
        endGame = (Button) findViewById(R.id.end_game);
        gv = (GridLayout)    findViewById(R.id.grid_layout);


        tryAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                revertTiles();
            }
        });

        newGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                quit = false;
                tryAgain.setVisibility(View.VISIBLE);
                newGame.setText("NEW GAME");
                endGame.setText("END GAME");
                clearAll();
                if(!firstTime)
                {
                    for(int i = 0; i < 20; i ++)
                    {
                        buttonArray[i].setOnClickListener(myListener);
                        buttonArray[i].setVisibility(View.INVISIBLE);
                        buttonArray[i].setBackgroundResource(R.drawable.buttonshape);
                        buttonArray[i].setTextColor(Color.parseColor("#4F4F4F"));
                    }

                }
                Intent intent = new Intent(MainActivity.this, TileSelector.class);
                startActivityForResult(intent, 1);

            }
        });

        endGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(quit)
                {
                    finish();
                }
                for(int i = 0; i < numTiles; i ++)
                {
                    buttonArray[i].setTextColor(Color.WHITE);
                }
                tryAgain.setVisibility(View.INVISIBLE);
                endGame.setText("QUIT");
                newGame.setText("KEEP PLAYING");
                firstTime = false;
                quit = true;

            }
        });


        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ontarget);

        ToggleButton toggle = findViewById(R.id.musicToggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    mediaPlayer.start();

                    Toast.makeText(getBaseContext(),"Music On",Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.pause();
                    Toast.makeText(getBaseContext(),"Music Off",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    View.OnClickListener myListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            String temp = "";
            switch (view.getId())
            {
                case R.id.button1:
                    buttonArray[0].setTextColor(Color.WHITE);
                    temp = buttonArray[0].getText().toString();
                    break;
                case R.id.button2:
                    buttonArray[1].setTextColor(Color.WHITE);
                    temp = buttonArray[1].getText().toString();

                    break;
                case R.id.button3:
                    buttonArray[2].setTextColor(Color.WHITE);
                    temp = buttonArray[2].getText().toString();
                    break;
                case R.id.button4:
                    buttonArray[3].setTextColor(Color.WHITE);
                    temp = buttonArray[3].getText().toString();
                     break;
                case R.id.button5:
                    buttonArray[4].setTextColor(Color.WHITE);
                    temp = buttonArray[4].getText().toString();
                    break;
                case R.id.button6:
                    buttonArray[5].setTextColor(Color.WHITE);
                    temp = buttonArray[5].getText().toString();
                    break;
                case R.id.button7:
                    buttonArray[6].setTextColor(Color.WHITE);
                    temp = buttonArray[6].getText().toString();
                    break;
                case R.id.button8:
                    buttonArray[7].setTextColor(Color.WHITE);
                    temp = buttonArray[7].getText().toString();
                    break;
                case R.id.button9:
                    buttonArray[8].setTextColor(Color.WHITE);
                    temp = buttonArray[8].getText().toString();
                    break;
                case R.id.button10:
                    buttonArray[9].setTextColor(Color.WHITE);
                    temp = buttonArray[9].getText().toString();
                    break;
                case R.id.button11:
                    buttonArray[10].setTextColor(Color.WHITE);
                    temp = buttonArray[10].getText().toString();
                    break;
                case R.id.button12:
                    buttonArray[11].setTextColor(Color.WHITE);
                    temp = buttonArray[11].getText().toString();
                    break;
                case R.id.button13:
                    buttonArray[12].setTextColor(Color.WHITE);
                    temp = buttonArray[12].getText().toString();
                    break;
                case R.id.button14:
                    buttonArray[13].setTextColor(Color.WHITE);
                    temp = buttonArray[13].getText().toString();
                    break;
                case R.id.button15:
                    buttonArray[14].setTextColor(Color.WHITE);
                    temp = buttonArray[14].getText().toString();
                    break;
                case R.id.button16:
                    buttonArray[15].setTextColor(Color.WHITE);
                    temp = buttonArray[15].getText().toString();
                    break;
                case R.id.button17:
                    buttonArray[16].setTextColor(Color.WHITE);
                    temp = buttonArray[16].getText().toString();
                    break;
                case R.id.button18:
                    buttonArray[17].setTextColor(Color.WHITE);
                    temp = buttonArray[17].getText().toString();
                    break;
                case R.id.button19:
                    buttonArray[18].setTextColor(Color.WHITE);
                    temp = buttonArray[18].getText().toString();
                    break;
                case R.id.button20:
                    buttonArray[19].setTextColor(Color.WHITE);
                    temp = buttonArray[19].getText().toString();
                    break;
            }
            guesses.add(temp);
            numTries ++;


            if(numTries == 2)
            {
                checkGuess();
                numTries = 0;
            }
        }
    };

    public boolean playerWin()
    {
        return tilesRemaining == 0;
    }
    public void clearAll()
    {
        numTries = 0;
        numTiles = 0;
        tilesRemaining = 0;
        guesses.clear();
    }
    public void checkGuess()
    {
        if(guesses.get(0).equals(guesses.get(1)))
        {
            deleteTile(guesses.get(0));
            tilesRemaining -=2 ;
            if(playerWin())
            {
                points +=2;
                Score.setText(Integer.toString(points));
                int duration = Toast.LENGTH_LONG;
                Context c = getApplicationContext();
                CharSequence t = "Congratulations, you've won!\n" +
                                 "Press new game to play again, or end game to quit";

                Toast tst = Toast.makeText(c, t, duration);
                tst.show();
                tryAgain.setVisibility(View.INVISIBLE);
                firstTime = false;
            }
            else
            {
                int duration = Toast.LENGTH_LONG;
                Context c = getApplicationContext();
                CharSequence t = "Correct Guess!";
                points +=2;
                Score.setText(Integer.toString(points));
                int d = Toast.LENGTH_SHORT;

                Toast tst = Toast.makeText(c, t, duration);
                tst.show();
            }
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect Guess!";
            int duration = Toast.LENGTH_SHORT;
            if(points > 0)
            {
                points = points -1 ;
                Score.setText(Integer.toString(points));
            }

            Score.setText(Integer.toString(points));
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            for(int i = 0; i < numTiles; i ++)
            {
                buttonArray[i].setOnClickListener(null);
            }
        }
    }
    public void revertTiles()
    {
        for(int i = 0; i < numTiles; i ++)
        {
            buttonArray[i].setBackgroundResource(R.drawable.buttonshape);
            buttonArray[i].setTextColor(Color.parseColor("#4F4F4F"));
        }
        for(int i = 0; i < numTiles; i ++)
        {
            buttonArray[i].setOnClickListener(myListener);
        }
        guesses.clear();
    }
    public void deleteTile(String guess)
    {
        for(int i = 0; i < 20; i ++)
        {
            if(buttonArray[i].getText().toString().equals(guess))
            {
                buttonArray[i].setVisibility(View.INVISIBLE);
            }
        }
        guesses.clear();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                int result=data.getIntExtra("result", 1);
                numTiles = result;
                tilesRemaining = numTiles;
                selectList();

            }
            if (resultCode == Activity.RESULT_CANCELED)
            {
                //Write your code if there's no result
            }
        }
    }

    public void selectList()
    {
        String temp1[] = new String[numTiles/2];
        String temp2[] = new String[numTiles/2];
        List<String> tempList;
        for(int i = 0; i < numTiles/2; i ++)
        {
            temp1[i] = fullAnimalList[i];
            temp2[i] = fullAnimalList[i];
        }
        tempList = new ArrayList<>(Arrays.asList(temp1));
        tempList.addAll(Arrays.asList(temp2));
        Collections.shuffle(tempList);

        for(int i = 0; i < numTiles; i ++)
        {
            buttonArray[i].setVisibility(View.VISIBLE);
            buttonArray[i].setText(tempList.get(i));
        }
    }
//
//    private int numTries = 0;
//    private int points = 0;
//    private int numTiles;
//    private int tilesRemaining;
//    private boolean firstTime = true;
//    boolean quit = false;
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("score",points);
        savedInstanceState.putInt("numTries", numTries);
        savedInstanceState.putInt("numTiles", numTiles);
        savedInstanceState.putInt("tilesRemaining", tilesRemaining);
        savedInstanceState.putBoolean("firstTime", firstTime);
        savedInstanceState.putBoolean("quit", quit);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        points = savedInstanceState.getInt("score");
        numTries = savedInstanceState.getInt("numTries");
        numTiles = savedInstanceState.getInt("numTiles");
        tilesRemaining = savedInstanceState.getInt("tilesRemaining");
        firstTime = savedInstanceState.getBoolean("firstTime");
        quit = savedInstanceState.getBoolean("quit");
        selectList();
        Log.d("VIVZ", points+ " was restored");
    }

}
