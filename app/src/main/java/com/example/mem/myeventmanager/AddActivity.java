package com.example.mem.myeventmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Vibrator;

/**
 * Created by Djina on 30.3.2016.
 */
public class AddActivity extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
    }

    EditText message_text;
    public final static String MESSAGE_KEY = "com.example.mem.myeventmanager.message_key";

    public void sendMessage(View views)
    {
        message_text = (EditText)findViewById(R.id.message_text);
        String message=message_text.getText().toString();
        Intent intent = new Intent(this, ListActivities.class);
        intent.putExtra(MESSAGE_KEY, message);
        startActivity(intent);
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
