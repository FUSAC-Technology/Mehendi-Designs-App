package com.capstone.new_latest_mehndi_designs_2021;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;

public class Base_Class extends AppCompatActivity {

    AdView adView;
    AdRequest adRequest;
    InterstitialAd interstitial;
    NativeAd nativeAd;

    public void bannerAd( AdView adView){
        this.adView = adView;
        adRequest = new AdRequest.Builder().build();
        this.adView.loadAd(adRequest);
        this.adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Base_Class.this.adView.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAdFailedToLoad(LoadAdError error) {
                Base_Class.this.adView.setVisibility(View.GONE);
            }
        });
    }

    void loadInterstitial(Context context) {
        InterstitialAd.load(context, context.getString(R.string.inter_id), adRequest,  new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                interstitial = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                interstitial = null;
            }
        });
    }
    void showInterstitial(Context context)
    {
        if(interstitial!=null)
        {
            interstitial.show((Activity)context);
            loadInterstitial(context);
        }
    }
}