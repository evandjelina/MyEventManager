package com.example.mem.myeventmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Djina on 31.3.2016.
 */
public class OpenCal extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_cal);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
