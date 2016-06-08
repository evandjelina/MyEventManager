package com.example.mem.myeventmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Djina on 31.3.2016.
 */
public class ListActivities extends Activity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] android_versions= {"Jedan", "Dva", "Android"};



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activities);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MESSAGE_KEY);
        //TextView textView = new TextView(this);
       // textView.setTextSize(45);
       // textView.setText(message);
        //setContentView(textView);

        /*android_versions[0]="Prooba";

        int s = returnPosition();
        android_versions[s]=message;*/


        listView = (ListView) findViewById(R.id.list_view);
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android_versions);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public final static String MESSAGE_KEY = "com.example.mem.myeventmanager.message_key";


//
    private ArrayList <String> list = new ArrayList<>();
   // private ArrayAdapter<String> adapter;


    String [] listForView = new String[100];

//
    public void printList(ArrayList <ActivityItems> list){
        for (int i=0; i<list.size(); i++){
            listForView[i] = list.get(i).getName()+" "+list.get(i).getDescription();
        }
    }

    public int returnPosition () {
        int i=0;
        while(android_versions[i]!=null)
            i++;
        return i;

    }

    public void cancel(View view){
        if(view.getId()==R.id.btnCancel){
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(50);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}
