package com.example.nhungnguyen.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText user, pass;
    RadioButton male, female;
    RadioGroup rdgr;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        rdgr = (RadioGroup) findViewById(R.id.rdgr);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb5 = (CheckBox) findViewById(R.id.cb5);
        cb6 = (CheckBox) findViewById(R.id.cb6);
        int idchecked = rdgr.getCheckedRadioButtonId();
        switch (idchecked) {
            case R.id.male:
                break;
            case R.id.female:
                break;
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";
                List<CheckBox> items=new ArrayList<CheckBox>();
                items.add(cb1);
                items.add(cb2);
                items.add(cb3);
                items.add(cb4);
                items.add(cb5);
                items.add(cb6);
                for (CheckBox item : items){
                    if(item.isChecked()) {
                        text += item.getText().toString() + " ";
                    }
                }
                Toast.makeText(MainActivity.this, "\n User: " + user.getText().toString() + " \n Pass: " + pass.getText().toString() + " \n sex: " + setSex() + " \n Hobby: " + text, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    public CharSequence setSex() {

        if (male.isChecked())
            return male.getText().toString();
        else if (female.isChecked())
            return female.getText().toString();
        else
            return null;
    }
}
