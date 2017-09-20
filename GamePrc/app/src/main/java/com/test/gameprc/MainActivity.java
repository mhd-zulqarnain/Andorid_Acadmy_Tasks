package com.test.gameprc;

import android.graphics.Color;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView tv;
    private Button btn;

    Random rand;
//    Dice stuff-----
    int dice1;
    int dice2;
    int dice3;
    ArrayList<ImageView> diceV;
    ArrayList<Integer> dice;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tv=(TextView)findViewById(R.id.headerText);
        btn=(Button)findViewById(R.id.btnClick);
        rand = new Random();
        //Dice Stuff
        ImageView die1=(ImageView)findViewById(R.id.die_1);
        ImageView die2=(ImageView)findViewById(R.id.die_2);
        ImageView die3=(ImageView)findViewById(R.id.die_3);
        dice=new ArrayList<Integer>();
        diceV= new ArrayList<ImageView>();
        diceV.add(die1);
        diceV.add(die2);
        diceV.add(die3);
    }

    public void changeText(View v){
        int dice1=rand.nextInt(6)+1;
        int dice2=rand.nextInt(6)+1;
        int dice3=rand.nextInt(6)+1;
        dice.clear();
        dice.add(dice1);
        dice.add(dice2);
        dice.add(dice3);
        for(int ds=0;ds<3;ds++){
            String
        }

        tv.setText("Here the number ");


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
