package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserContact extends AppCompatActivity {

    Button switchButton;

    public EditText uName;
    public  EditText uEmail;
    public  EditText uPhone;
    public  EditText uComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercontact);

        //tilslutter UI til kode
        switchButton = findViewById(R.id.sendorder);

        //brugerens input
        uName = findViewById(R.id.name);
        uEmail = findViewById(R.id.email);
        uPhone = findViewById(R.id.phone);
        uComments = findViewById(R.id.comments);
        View uMaker = findViewById(R.id.dropdownlist);

        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

       // Intent intentu = new Intent(this, ShowAccept.class);
      //  startActivity(intentu);

        //test to send mail instead to show confirm activity
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{uEmail.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Tilbud");
        intent.putExtra(Intent.EXTRA_TEXT, uComments.getText().toString());
        // intent.setType("message/rfc822");

        intent.setData(Uri.parse("mailto:"));
        startActivity(intent);
    }
}