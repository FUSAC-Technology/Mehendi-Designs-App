package com.capstone.new_latest_mehndi_designs_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecView_List extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Drawable> imgList= new ArrayList<>();
    String category_name;
    Images_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recview_list);

        initialize();

        setRecView();
    }

    private void setRecView() {
        GridLayoutManager layoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        getImages();

        adapter= new Images_Adapter(imgList,category_name, this);
        recyclerView.setAdapter(adapter);

    }

    private void getImages() {
        category_name = getIntent().getStringExtra("category_name");

        // to reach asset
        AssetManager assetManager = getAssets();

        try {
            String[] images = new String[0];
            images = assetManager.list(category_name);

            for (int i = 0; i < images.length; i++) {

                InputStream inputStream;
                inputStream = getAssets().open(category_name+"/" + images[i]);
                Drawable d = Drawable.createFromStream(inputStream, null);
                imgList.add(d);
            }
        }

        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void initialize() {
        recyclerView=findViewById(R.id.recyclerview);
    }
}