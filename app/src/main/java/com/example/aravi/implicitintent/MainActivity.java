package com.example.aravi.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText urlField;
    EditText phonenumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    protected void launchBrowser(View view) {
        urlField = (EditText) findViewById(R.id.urlFieldId);
        String urlSring = urlField.getText().toString();
        if (!urlSring.equals("")) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(urlSring));
            startActivity(intent);
        } else {
            Toast.makeText(this, "Url Cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }


    protected void launchDialer(View view) {
        phonenumberField = (EditText) findViewById(R.id.phonenumberFieldId);
        String phoneNumber = phonenumberField.getText().toString();
        if (!phoneNumber.equals("")) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        } else {
            Toast.makeText(this, "Phone no field cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }

}
