package com.capstone.mehendidesignsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_wedding;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        buttonsClick();

    }

    private void buttonsClick() {

        btn_wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category= "Wedding";
                Intent intent= new Intent(MainActivity.this, RecView_List.class);
                intent.putExtra("category_name",category);
                startActivity(intent);
            }
        });
    }

    private void initialize() {
        btn_wedding=findViewById(R.id.btn_wedding);
    }
}