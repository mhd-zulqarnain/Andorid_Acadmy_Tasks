package com.me.diceout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private  int num;
    private TextView rollResult ;
//    private Button rollButton ;
    Random rand;
//   Dice image content
    int die1;
    int die2;
    int die3;
    ArrayList<ImageView> diceImgView;
    ArrayList<Integer> dice;
    TextView scoreView;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice(view);
            }
        });

        Toast.makeText(getApplicationContext(),"Welcome its gonna fade out",Toast.LENGTH_SHORT).show();
//        rollButton=(Button)findViewById(R.id.rollButton);
        rollResult=(TextView)findViewById(R.id.rollResult);
        rand=new Random();
        dice=new ArrayList<Integer>();
        diceImgView= new ArrayList<ImageView>();
        ImageView dice1=(ImageView)findViewById(R.id.dice_1);
        ImageView dice2=(ImageView)findViewById(R.id.dice_2);
        ImageView dice3=(ImageView)findViewById(R.id.dice_3);
        diceImgView.add(dice1);
        diceImgView.add(dice2);
        diceImgView.add(dice3);
//        Score view
        scoreView = (TextView)findViewById(R.id.scoreView);

    }
    public void rollDice(View v){

        die1=rand.nextInt(6)+1;
        die2=rand.nextInt(6)+1;
        die3=rand.nextInt(6)+1;

        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        for(int ds=0;ds<3;ds++){
            String imgName="die_"+dice.get(ds)+".png";
            try{
                InputStream stream = getAssets().open(imgName);
                Drawable d=Drawable.createFromStream(stream,null);
                diceImgView.get(ds).setImageDrawable(d);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        String msg="";
        if(die1==die2&&die1==die3){
            score+=die1*100;
            msg="You score 100 points";

        }
        else if(die1==die2 || die1==die3 || die2==die3){
            score+=50;
            msg="You score 50 points";
        }
        else{
            msg="You didn't score points ! Try again";
        }
        scoreView.setText("Score: "+score);
        rollResult.setText(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
