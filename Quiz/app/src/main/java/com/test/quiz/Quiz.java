package com.test.quiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    ArrayList<EditText> ed;
    EditText editText;
    Button calc;
    TextView status;
    SharedPreferences shp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        EditText foodEdit=(EditText)findViewById(R.id.foodEdit);
        EditText shopEdit=(EditText)findViewById(R.id.shopEdit);
        EditText fuelEdit=(EditText)findViewById(R.id.fuelEdit);
        EditText teleEdit=(EditText)findViewById(R.id.teleEdit);

        ed=new ArrayList<EditText>();
        ed.add(foodEdit);
        ed.add(shopEdit);
        ed.add(fuelEdit);
        ed.add(teleEdit);

        calc=(Button)findViewById(R.id.calc);
        status=(TextView)findViewById(R.id.textView2);
        readData();
        //shp=getSharedPreferences("EXPENSE", Context.MODE_PRIVATE);

        //status.setText(shp.getString("EXP","No data"));

    }

    public void calculate(View v){
        int sum=0;
        for(int i=0;i<ed.size();i++){
            editText=ed.get(i);
            sum+=Integer.parseInt(editText.getText().toString().replaceAll("[\\D]",""));

        }
        //Saving values in sharded preferences
        //SharedPreferences.Editor edit=shp.edit();
        //edit.putString("EXP",String.valueOf(sum));
        //edit.apply();
        //-----------
        Toast.makeText(this, "Total epense became "+sum, Toast.LENGTH_SHORT).show();
        saveData();
       status.setText(String.valueOf(sum));
    }

    public void saveData(){
        try{
            FileOutputStream out=openFileOutput("expense.txt",MODE_PRIVATE);
            out.write(status.getText().toString().getBytes());
            out.close();
        }catch (IOException e){
            System.out.println("file can't save"+e);

        }
    }

    public void readData(){
        try{
            FileInputStream in=openFileInput("expense.txt");
            InputStreamReader is= new InputStreamReader(in);

            BufferedReader reader = new BufferedReader(is);
            String data=reader.readLine();

            if(!data.isEmpty()){
                status.setText(data);
            }
            else {
                status.setText(0);
            }
        }
        catch (FileNotFoundException e){
            status.setText("No data found");
        }
        catch (IOException e){
            System.out.println("File not exist");
        }
    }

}
