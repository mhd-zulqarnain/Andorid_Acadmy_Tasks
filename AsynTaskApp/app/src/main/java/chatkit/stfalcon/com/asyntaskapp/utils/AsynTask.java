package chatkit.stfalcon.com.asyntaskapp.utils;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import chatkit.stfalcon.com.asyntaskapp.model.Student;

/**
 * Created by Zul Qarnain on 12/26/2017.
 */

public class AsynTask extends AsyncTask<String,Void,ArrayList<Student>> {
    ArrayList<Student> stdList=new ArrayList<>();
    @Override
    protected ArrayList<Student> doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String json ="";
            String line;
            while ((line =reader.readLine())!=null){
                json+=line;
            }
            Student students[] = new Gson().fromJson(json,Student[].class);
            for(int i=0;i<students.length;i++){
                stdList.add(students[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stdList;
    }

    @Override
    protected void onPostExecute(ArrayList<Student> list) {
        super.onPostExecute(list);


    }
}
