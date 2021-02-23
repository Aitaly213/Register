package com.geektech.reg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int adfb =1;
    int counter = 0;
    int counter_password = 0;
    Button button;
    boolean isTrue = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       button = findViewById(R.id.btn1);
        EditText editText1 = findViewById(R.id.register_text);
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    counter += count;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText editText2 = findViewById(R.id.password);
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    counter_password += 1;
                } else {
                    counter_password -= 1;
                }

                if (counter >= 8 && counter_password >= 6) {
                    button.setBackgroundColor(getResources().getColor(R.color.purple_700));
                    isTrue = true;
                }if (counter_password < 6) {
                        button.setBackgroundColor(getResources().getColor(R.color.grey));
                        isTrue = false;
                    }

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void registerE(View view){
        if (counter >= 8 && counter_password >= 6) {
            isTrue = true;
            Toast toast = Toast.makeText(this, "WELCOME!!!", Toast.LENGTH_LONG);
            toast.show();
        }if (counter_password < 6) {
            isTrue = false;
        }
    }
}