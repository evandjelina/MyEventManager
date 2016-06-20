package com.example.mem.myeventmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivities extends Activity {

    //dugme za vracanje u meni, sa vibracijom od 50
    public void cancelAct(View view){
        if(view.getId()==R.id.btnCancel){
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(50);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activities);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    private void displayListView() {

        ArrayList<Aktivnost> aktivnosti = new ArrayList<Aktivnost>();

        Aktivnost akt1 = new Aktivnost("dan 1", "Napravi cilj projekta!", false);
        aktivnosti.add(akt1);

        Aktivnost akt2 = new Aktivnost("dan 3", "Utvrdi podelu poslova!", false);
        aktivnosti.add(akt2);

        Aktivnost akt3 = new Aktivnost("dan 5", "Organizuj tim!", false);
        aktivnosti.add(akt3);

        Aktivnost akt4 = new Aktivnost("dan 9", "Nađi sponzore!", false);
        aktivnosti.add(akt4);

        Aktivnost akt5 = new Aktivnost("dan 9", "Organizuj promociju!", false);
        aktivnosti.add(akt5);

        Aktivnost akt6 = new Aktivnost("dan 16", "Presek stanja!", false);
        aktivnosti.add(akt6);

        Aktivnost akt7 = new Aktivnost("dan 20", "Poslednje pripreme...", false);
        aktivnosti.add(akt7);

        Aktivnost akt8 = new Aktivnost("dan 25", "Uživaj u događaju! :)", false);
        aktivnosti.add(akt8);

        dataAdapter = new MyCustomAdapter(this,
                R.layout.aktivnost_info, aktivnosti);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Aktivnost country = (Aktivnost) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Odradili ste: " + country.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Aktivnost> {

        private ArrayList<Aktivnost> aktivnosti;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Aktivnost> aktivnosti) {
            super(context, textViewResourceId, aktivnosti);
            this.aktivnosti = new ArrayList<Aktivnost>();
            this.aktivnosti.addAll(aktivnosti);
        }

        private class ViewHolder {
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.aktivnost_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        Aktivnost country = (Aktivnost) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Odradili ste: " + cb.getText() +
                                        " " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Aktivnost aktivnost = aktivnosti.get(position);
            holder.code.setText(" (" + aktivnost.getCode() + ")");
            holder.name.setText(aktivnost.getName());
            holder.name.setChecked(aktivnost.isSelected());
            holder.name.setTag(aktivnost);

            return convertView;


        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("Sledeće aktivnosti su urađene...\n");

                ArrayList<Aktivnost> aktivnosti = dataAdapter.aktivnosti;
                for(int i=0;i<aktivnosti.size();i++){
                    Aktivnost aktivnost = aktivnosti.get(i);
                    if(aktivnost.isSelected()){
                        responseText.append("\n" + aktivnost.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }

}













   /* ListView listView;
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
        android_versions[s]=message;


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
 */






