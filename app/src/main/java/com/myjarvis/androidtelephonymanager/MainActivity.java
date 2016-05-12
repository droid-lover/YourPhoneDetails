package com.myjarvis.androidtelephonymanager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/*
*
* */

public class MainActivity extends AppCompatActivity {

    TextView telephonyActivityTextView;

    TelephonyManager telephonyManager;

    String IMEINumber, subscriberID, SIMSerialNumber, networkCountryISO,
            SIMCountryISO, softwareVersion, voiceMailNumber;

    String phoneType = "";

    boolean isRoaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telephonyActivityTextView = (TextView) findViewById(R.id.telephonyActivityTextView);


            //instance of telephone manager
            telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);


            //Calling the methods of TelephonyManager the returns the information
            IMEINumber = telephonyManager.getDeviceId();
            subscriberID = telephonyManager.getDeviceId();
            SIMSerialNumber = telephonyManager.getSimSerialNumber();
            networkCountryISO = telephonyManager.getNetworkCountryIso();
            SIMCountryISO = telephonyManager.getSimCountryIso();
            softwareVersion = telephonyManager.getDeviceSoftwareVersion();
            voiceMailNumber = telephonyManager.getVoiceMailNumber();


            int phoneType = telephonyManager.getPhoneType();

            switch (phoneType) {
                case (TelephonyManager.PHONE_TYPE_CDMA):
                    this.phoneType = "CDMA";
                    break;
                case (TelephonyManager.PHONE_TYPE_GSM):
                    this.phoneType = "GSM";
                    break;
                case (TelephonyManager.PHONE_TYPE_NONE):
                    this.phoneType = "NONE";
                    break;
            }

            //getting information if phone is in roaming
            isRoaming = telephonyManager.isNetworkRoaming();

            String info = "Phone Details:\n";
            info += "\n IMEI Number:" + IMEINumber;
            info += "\n SubscriberID:" + subscriberID;
            info += "\n Sim Serial Number:" + SIMSerialNumber;
            info += "\n Network Country ISO:" + networkCountryISO;
            info += "\n SIM Country ISO:" + SIMCountryISO;
            info += "\n Software Version:" + softwareVersion;
            info += "\n Voice Mail Number:" + voiceMailNumber;
            info += "\n Phone Network Type:" + this.phoneType;
            info += "\n In Roaming? :" + isRoaming;

            telephonyActivityTextView.setText(info);//displaying the information in the textView

    }


}

