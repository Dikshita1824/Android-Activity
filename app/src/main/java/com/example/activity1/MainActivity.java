package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name, mn, address;
    RadioButton male, female, other;
    CheckBox rb, dance, sing, travel;
    TextView tv;

    ImageButton dobbtn;
    AppCompatButton submit;

    String dob = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mn = findViewById(R.id.mn);
        address = findViewById(R.id.address);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.other);

        rb = findViewById(R.id.rb);
        dance = findViewById(R.id.dance);
        sing = findViewById(R.id.sing);
        travel = findViewById(R.id.travel);

        tv = findViewById(R.id.tv);

        dobbtn = findViewById(R.id.dobbtn);
        submit = findViewById(R.id.submit);

        dobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dp = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int y, int m, int d) {

                                dob = d + "/" + (m + 1) + "/" + y;

                            }
                        }, year, month, day);

                dp.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n = name.getText().toString();
                String m = mn.getText().toString();
                String a = address.getText().toString();

                String gender = "";

                if (male.isChecked())
                    gender = "Male";
                else if (female.isChecked())
                    gender = "Female";
                else if (other.isChecked())
                    gender = "Other";

                String hobbies = "";

                if (rb.isChecked())
                    hobbies += "Reading, ";
                if (dance.isChecked())
                    hobbies += "Dancing, ";
                if (sing.isChecked())
                    hobbies += "Singing, ";
                if (travel.isChecked())
                    hobbies += "Travelling ";

                tv.setText(
                         "Your name is " + n +
                                " & your mobile no. is " + m +
                                " & your address is " + a +
                                ".Your gender is " + gender +
                                ".You were born on " + dob +
                                " & you like to " + hobbies
                );

            }
        });

    }
}