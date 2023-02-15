package com.example.selectlaunguage_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    ArrayAdapter<String> adapter;
    Button btnLanguage;
    String[] lan={"Select Language","hindi","english"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lan);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getSelectedItem().equals("english")){
                    setLocal(MainActivity.this,"en");
                    startActivity(getIntent());
                    finish();
                    overridePendingTransition(0, 0);
                }
                else if(adapterView.getSelectedItem().equals("hindi")){
                    setLocal(MainActivity.this,"hi");
                    startActivity(getIntent());
                    finish();
                    overridePendingTransition(0, 0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });



    }

    private void setLocal(Activity activity, String en) {
        Locale locale = new Locale(en);
        locale.setDefault(locale);

        Resources resources = activity.getResources();

        Configuration configuration = resources.getConfiguration();

        configuration.setLocale(locale);

        resources.updateConfiguration(configuration,resources.getDisplayMetrics());



    }
}