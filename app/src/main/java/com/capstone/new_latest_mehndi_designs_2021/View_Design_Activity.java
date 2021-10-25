package com.capstone.new_latest_mehndi_designs_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;
import java.io.InputStream;

public class View_Design_Activity extends AppCompatActivity {
    PhotoView photoView;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_design);

        initialize();

        showImage();
    }

    private void showImage() {
        int position = getIntent().getIntExtra("image_position", 0);
        String category=getIntent().getStringExtra("categoryName");

        try {
            String[] images;

            AssetManager assetManager= getAssets();
            images = assetManager.list(category);

            InputStream inputStream;
            inputStream = getAssets().open(category+"/" + images[position]);
            Drawable d = Drawable.createFromStream(inputStream, null);

            title= images[position];

            photoView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        photoView=findViewById(R.id.mehendi_img);
    }

    public void DownloadClick(View view){

        if (ContextCompat.checkSelfPermission(View_Design_Activity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(View_Design_Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(View_Design_Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
            ActivityCompat.requestPermissions(View_Design_Activity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
            Toast.makeText(View_Design_Activity.this, "Need permission for external storage...", Toast.LENGTH_SHORT).show();
        }
        else{
            photoView.setDrawingCacheEnabled(true);
            Bitmap bitmap = photoView.getDrawingCache();
            MediaStore.Images.Media.insertImage(this.getContentResolver(), bitmap,title, null);

            Toast.makeText(View_Design_Activity.this, "Downloading...", Toast.LENGTH_SHORT).show();

        }
    }

    public void ShareClick(View view){

        if (ContextCompat.checkSelfPermission(View_Design_Activity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(View_Design_Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(View_Design_Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
            ActivityCompat.requestPermissions(View_Design_Activity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
            Toast.makeText(View_Design_Activity.this, "Need permission for external storage...", Toast.LENGTH_SHORT).show();
        }
        else{
            photoView.setDrawingCacheEnabled(true);
            Bitmap bitmap = photoView.getDrawingCache();

            String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap,"title", null);
            Uri bitmapUri = Uri.parse(bitmapPath);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/png");
            intent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
            startActivity(Intent.createChooser(intent, "Share"));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void BackButton(View view){
        onBackPressed();
    }
}