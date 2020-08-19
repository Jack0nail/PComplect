package com.example.pcomplect;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<String> arrayList = new ArrayList<>();
String file_name = "Ara.json";
JSONArray jsarr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void choseCPU (View view)
    {
        setContentView(R.layout.list_activity);
        listView = findViewById(R.id.pcList);
        try {
            jsarr = (JSONArray) new JSONParser().parse(new Save_json().getAssetsfile(file_name, this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Object wetr: jsarr)
        {
            JSONObject jsobj = (JSONObject) wetr;
            String id = (String) jsobj.get("Complect");
            arrayList.add(id);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(adapter);
        }
    }
}
