package com.example.pcomplect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.simple.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.pcList);
        JSONArray jsarr = new Save_json().readFile(this);
        for (Object wetr: jsarr)
        {
            String textobj = wetr.toString();
            arrayList.add(textobj);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_item, arrayList);
            listView.setAdapter(adapter);
        }
    }

    public void choseCPU (View view)
    {
        setContentView(R.layout.list_activity);

    }
}
