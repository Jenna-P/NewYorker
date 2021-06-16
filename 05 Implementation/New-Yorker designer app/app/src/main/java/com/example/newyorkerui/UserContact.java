package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import Logic.DbAdapter;
import Model.PersonData;

public class UserContact extends AppCompatActivity {

    Button switchButton;
    Spinner dropdownlist;

    public EditText uName;
    public  EditText uEmail;
    public  EditText uPhone;
    public  EditText uComments;

    DbAdapter db; // Android Sqlite

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercontact);

        //tilslutter UI til kode
        switchButton = findViewById(R.id.sendorder);
        dropdownlist = (Spinner) findViewById(R.id.dropdownlist);

        //brugerens input
        uName = findViewById(R.id.name);
        uEmail = findViewById(R.id.email);
        uPhone = findViewById(R.id.phone);
        uComments = findViewById(R.id.comments);
        View uMaker = findViewById(R.id.dropdownlist);

        db = new DbAdapter(this);

        dropdownlist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                Log.d("spinner", parent.getItemAtPosition(position).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {



        getPersonData();

        //test to send mail instead to show confirm activity
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{uEmail.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Tilbud");
        intent.putExtra(Intent.EXTRA_TEXT, uComments.getText().toString());
        // intent.setType("message/rfc822");

        intent.setData(Uri.parse("mailto:"));
        startActivity(intent);
    }

    public void getPersonData() {
        PersonData pd = new PersonData();
       // ConnectToDB cd = new ConnectToDB();

       String dataName = uName.getText().toString();
       String dataEmail = uEmail.getText().toString();
       String dataPhone = uPhone.getText().toString();

       pd.setName(dataName);
       pd.setEmail(dataEmail);
       pd.setPhoneNumber(dataPhone);

      // cd.insertIntoPersonData(pd.getName(),pd.getPhoneNumber(),pd.getEmail());
        db.insertData(pd.getName(),pd.getEmail(),pd.getPhoneNumber());

        System.out.println(db.getData()); //see data is inserted right
    }


}