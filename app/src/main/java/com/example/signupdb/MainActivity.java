package com.example.signupdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button button2, button3;
    EditText editText3, editText4, editText5, editText6, editText7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        openHelper = new DatabaseHelper(this);
          editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        button3=(Button)findViewById(R.id.button3);
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname=editText3.getText().toString();
                String lname=editText4.getText().toString();
                String pass=editText5.getText().toString();
                String email=editText5.getText().toString();
                String phone=editText7.getText().toString();
                insertdata(fname, lname,pass,email,phone);
                Toast.makeText(getApplicationContext(),
                        "register successfully",Toast.LENGTH_LONG).show();

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this, LoginMain.class);
                        startActivity(intent);

                    }
                });



            }
        });
    }
    public void insertdata(String fname, String lname, String pass, String email, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, lname);
        contentValues.put(DatabaseHelper.COL_4, pass);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6, phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}


