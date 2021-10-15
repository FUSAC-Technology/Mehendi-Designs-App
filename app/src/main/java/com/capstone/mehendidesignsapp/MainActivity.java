package com.capstone.mehendidesignsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_wedding, btn_arm;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();


    }


    private void initialize() {
    }

    public void Wedding_ClickEvent(View view){
        category= "Wedding";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

    public void Arm_ClickEvent(View view){
        category= "Arm";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

    public void EidSpecial_ClickEvent(View view){
        category= "Eid_Special";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

    public void BackHand_ClickEvent(View view){
        category= "Back_Hand";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

    public void FrontHand_ClickEvent(View view){
        category= "Front_Hand";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

    public void GolTikki_ClickEvent(View view){
        category= "Gol_Tikki";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

    public void Finger_ClickEvent(View view){
        category= "Finger";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

    public void Foot_ClickEvent(View view){
        category= "Foot";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);
    }

}