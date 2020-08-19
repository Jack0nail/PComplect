package com.example.pcomplect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Spinner spinner;
ArrayList<String> arrayList = new ArrayList<>();
String file_name = "Ara.json";
    String text_assets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        try {
            text_assets = new Save_json().getAssetsfile(file_name, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsarr = new Save_json().readFile(this, text_assets);
        for (Object wetr: jsarr)
        {
            String textobj = wetr.toString();
            arrayList.add(textobj);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_item, arrayList);
            spinner.setAdapter(adapter);
        }
    }

    public void choseCPU (View view)
    {
        setContentView(R.layout.list_activity);

    }
}
