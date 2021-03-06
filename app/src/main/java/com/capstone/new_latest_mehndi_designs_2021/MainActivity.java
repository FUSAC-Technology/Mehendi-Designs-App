package com.capstone.new_latest_mehndi_designs_2021;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.gms.ads.AdView;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends Base_Class {

    private MeowBottomNavigation bnv_Main;
    String category;
    AdView banner_Adview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        bottomNavMenu();

        bannerAd(banner_Adview);


    }


    private void initialize() {
        bnv_Main= findViewById(R.id.bnv_Main);
        banner_Adview=findViewById(R.id.banner_adview);
    }

    public void Wedding_ClickEvent(View view){
        category= "Wedding";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    public void Arm_ClickEvent(View view){
        category= "Arm";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    public void EidSpecial_ClickEvent(View view){
        category= "Eid_Special";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    public void BackHand_ClickEvent(View view){
        category= "Back_Hand";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    public void FrontHand_ClickEvent(View view){
        category= "Front_Hand";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    public void GolTikki_ClickEvent(View view){
        category= "Gol_Tikki";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    public void Finger_ClickEvent(View view){
        category= "Finger";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    public void Foot_ClickEvent(View view){
        category= "Foot";
        Intent intent= new Intent(MainActivity.this, RecView_List.class);
        intent.putExtra("category_name",category);
        startActivity(intent);

        //interstitial Ad
        loadInterstitial(MainActivity.this);
        showInterstitial(MainActivity.this);
    }

    private void bottomNavMenu() {
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_privacy_tip_24));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_share_24));
        bnv_Main.add(new MeowBottomNavigation.Model(4,R.drawable.ic_baseline_star_rate_24));

        bnv_Main.show(1,true);

        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        Intent intent= new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case 2:
                        Uri uri = Uri.parse("https://fusacbustech.com/privacy%20policy/"); // missing 'http://' will cause crashed
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;

                    case 3:
                        try {
                            Intent shareIntent = new Intent(Intent.ACTION_SEND);
                            shareIntent.setType("text/plain");
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                            String shareMessage= "\nLet me recommend you this amazing application\n\n";
                            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName() +"\n\n";
                            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                            startActivity(Intent.createChooser(shareIntent, "choose one"));
                        } catch(Exception e) {
                            //e.toString();
                        }
                        break;

                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getApplicationContext().getPackageName())));

                        break;


                }
                return null;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent= new Intent(this, Exit_Activity.class);
        startActivity(intent);
    }

}