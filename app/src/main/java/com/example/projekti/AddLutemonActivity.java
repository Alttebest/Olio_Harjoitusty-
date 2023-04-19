package com.example.projekti;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddLutemonActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
        context = this;
    }

    public void addLutemon(View view){
        String name;
        TextView txtName = findViewById(R.id.txtName);
        name = txtName.getText().toString();

        RadioGroup rgAddLutemon = findViewById(R.id.rgAddLutemon);

        if(rgAddLutemon.getCheckedRadioButtonId() == R.id.rbWhite) {
            Home.getInstance().createLutemon(new White(name));
        }
        else if(rgAddLutemon.getCheckedRadioButtonId() == R.id.rbGreen) {
            Home.getInstance().createLutemon(new Green(name));
        }
        else if(rgAddLutemon.getCheckedRadioButtonId() == R.id.rbPink) {
            Home.getInstance().createLutemon(new Pink(name));
        }
        else if(rgAddLutemon.getCheckedRadioButtonId() == R.id.rbOrange) {
            Home.getInstance().createLutemon(new Orange(name));
        }
        else if(rgAddLutemon.getCheckedRadioButtonId() == R.id.rbBlack) {
            Home.getInstance().createLutemon(new Black(name));
        }
        else {
            throw new IllegalStateException("Unexpected value: " + rgAddLutemon.getCheckedRadioButtonId());
        }
        Home.getInstance().saveLutemons(context);
    }
}
