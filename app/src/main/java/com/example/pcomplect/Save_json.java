package com.example.pcomplect;


import android.content.Context;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

class Save_json {
    public void writeFile(JSONArray listView, Context context) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(context.openFileOutput("name", MODE_PRIVATE)));
            bw.write(listView.toJSONString());
            bw.close();
            System.out.println("zalypa zapisalas");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    public JSONArray readFile(Context context)
    {

        JSONArray jsonstr = new JSONArray();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.openFileInput("name")));
            String str = "";
            StringBuilder strall = new StringBuilder("");

            while ((str = br.readLine()) != null)
            {
                strall.append(str);
            }
            jsonstr = (JSONArray)  new JSONParser().parse(strall.toString());
        }
        catch (FileNotFoundException e) {e.printStackTrace(); }
        catch (IOException e) {e.printStackTrace(); } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonstr;
    }
}