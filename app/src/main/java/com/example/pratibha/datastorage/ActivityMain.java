package com.example.pratibha.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class ActivityMain extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        info = (TextView) findViewById(R.id.info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            InputStream in = openFileInput(Preference.STORE_PREFERENCES);
            if(in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();
                while((str=reader.readLine())!=null) {
                    buf.append(str +"\n");
                }
                in.close();
                info.setText(buf.toString());
                info.setVisibility(View.VISIBLE);
            } else {
                info.setVisibility(View.INVISIBLE);
            }
        } catch(Exception e) {
            e.printStackTrace();
            info.setVisibility(View.INVISIBLE);
        }
    }


    public void onclickPreference(View v) {
        Intent intent = new Intent(this, Preference.class);
        startActivity(intent);
    }


    public void onclickSQLite(View v) {
        Intent intent = new Intent(this, SQLite.class);
        startActivity(intent);
    }


    public void closeApp(View v) {
        ActivityMain.this.finish();
        System.exit(0);
    }

    private void TeamUpload(){
        int i = 1+1;
        int j = 2;
    }
}
