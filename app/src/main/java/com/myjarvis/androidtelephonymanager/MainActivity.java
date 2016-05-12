package com.myjarvis.androidtelephonymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/*
*
* */

public class MainActivity extends AppCompatActivity {

    TextView yourPhoneDetailsTextView, makeACallTextView;

    Intent i = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yourPhoneDetailsTextView = (TextView) findViewById(R.id.yourPhoneDetailsTextView);
        makeACallTextView = (TextView) findViewById(R.id.makeACallTextView);

        yourPhoneDetailsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getBaseContext(), TelephonyDetailsActivity.class);
                startActivity(i);
            }
        });


        makeACallTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(getBaseContext(), MakeACallActivity.class);
                startActivity(i);
            }
        });
    }
}
