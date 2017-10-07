package com.example.bmi_cal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nHeightEditText,nWeightEditText;
    private Button nCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nHeightEditText = (EditText)findViewById(R.id.height_edit_text);
        nWeightEditText = (EditText)findViewById(R.id.weight_edit_text);
        nCalculateButton = (Button)findViewById(R.id.calculate_button);

        nCalculateButton.setOnClickListener(new View.OnClickListener() { //สร้าง listener
            @Override
            public void onClick(View v) {
                String heightText = nHeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);

                Double weight = Double.valueOf(nWeightEditText.getText().toString());

                Double bmi = weight / ((height/100)*(height/100));
                final String BMIText = getBmiText(bmi);
               /* String result = String.format("ค่า BMI คือ %.2f\n\nอยู่ในเกณฑ์ : %s",bmi,BMIText);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this); //สร้าง dialog
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nHeightEditText.setText("");
                        nWeightEditText.setText("");
                        nHeightEditText.requestFocus();

                    }
                });
                dialog.show();*/
                Intent intent = new Intent(MainActivity.this,BmiResultActivity.class);
                intent.putExtra("bmi_value",bmi);   // ใส่ค่าตัวเลข bmi ลงในอินเทนต์
                intent.putExtra("bmi_text", BMIText); // ใส่ข้อความ (ที่บอกผอม, ปกติ, อ้วน) ลงในอินเทนต์
                startActivity(intent); // ยิงอินเทนต์ออกไปให้ Android จัดการ (รันแอคทิวิตีใหม่)

            }
        });

    }

    private String getBmiText(Double bmi) {
        String BMIText = "";
        if (bmi < 18.5) {
            BMIText = "น้ำหนักน้อยกว่าปกติ";
        } else if (bmi < 25) {
            BMIText = "น้ำหนักปกติ";
        } else if (bmi < 30) {
            BMIText = "น้ำหนักมากกว่าปกติ(ท้วม)";
        } else {
            BMIText = "น้ำหนักมากกว่าปกติ(อ้วน)";
        }
        return BMIText;
    }


}


