package com.example.bmi_cal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        Intent intent = getIntent();
        Double bmi =  intent.getDoubleExtra("bmi_value", 0);
        String bmiText = intent.getStringExtra("bmi_text");

        TextView text = (TextView)findViewById(R.id.BmiDialog1);
        text.setText("ค่า Bmi ที่ได้คือ "+String.format("%.2f",bmi));

        TextView text2 =(TextView)findViewById(R.id.BmiDialog2);
        text2.setText("อยู่ในเกณฑ์ : "+bmiText);

    }
}
