package com.myjarvis.androidtelephonymanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MakeACallActivity extends AppCompatActivity {


    EditText usersNumberEditText;
    Button b;

    String enteredNumber;
    Intent makeCallIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_acall);

        usersNumberEditText = (EditText) findViewById(R.id.usersNumberEditText);
        b = (Button) findViewById(R.id.makeCallToEnteredNumButton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enteredNumber = usersNumberEditText.getText().toString();

                 makeCallIntent = new Intent(Intent.ACTION_CALL);
                makeCallIntent.setData(Uri.parse("your number is :" + enteredNumber));
                    startActivity(makeCallIntent);
                

            }
        });
    }
}
