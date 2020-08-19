package com.example.pcomplect;


import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String getAssetsfile(String file_name, Activity activity) throws IOException {
        AssetManager am = activity.getAssets();
        InputStream is = am.open(file_name);
        String s = convertStreamToString(is);
        is.close();
        System.out.println(s);
        return s;
    }
    public JSONArray readFile(Context context, String text_assets)
    {
        String test1;
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