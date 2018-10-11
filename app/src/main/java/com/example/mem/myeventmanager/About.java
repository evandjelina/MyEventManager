package com.example.mem.myeventmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

/**
 * Created by Djina on 31.3.2016.
 */
public class About extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
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
