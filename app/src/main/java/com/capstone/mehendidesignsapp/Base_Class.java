package com.capstone.mehendidesignsapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.Objects;

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