package com.eduwala.testapplovinad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapters.FacebookMediationAdapter;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.ads.AudienceNetworkAds;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements MaxAdListener {

    MaxAdView maxAdView, max_mrec_adView;
    private MaxInterstitialAd interstitialAd;
    private int retryAttempt;

    void createInterstitialAd()
    {
        interstitialAd = new MaxInterstitialAd( "9f655600609fd9a7", this );
        interstitialAd.setListener( this );

        // Load the first ad
        interstitialAd.loadAd();
    }

    // MAX Ad Listener
    @Override
    public void onAdLoaded(final MaxAd maxAd)
    {
        // Interstitial ad is ready to be shown. interstitialAd.isReady() will now return 'true'

        if ( interstitialAd.isReady() )
        {
            interstitialAd.showAd();
        }

        // Reset retry attempt
        //retryAttempt = 0;
    }

    @Override
    public void onAdLoadFailed(final String adUnitId, final MaxError error)
    {
        // Interstitial ad failed to load
        // We recommend retrying with exponentially higher delays up to a maximum delay (in this case 64 seconds)
        //startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    @Override
    public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error)
    {

    }

    @Override
    public void onAdDisplayed(final MaxAd maxAd) {

    }

    @Override
    public void onAdClicked(final MaxAd maxAd) {}

    @Override
    public void onAdHidden(final MaxAd maxAd)
    {
        // Interstitial ad is hidden. Pre-load the next ad
        //interstitialAd.loadAd();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudienceNetworkAds.initialize(this);


        FacebookMediationAdapter facebookMediationAdapter;
        // Please make sure to set the mediation provider value to "max" to ensure proper functionality
        AppLovinSdk.getInstance( this ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads
            }
        } );

        Button btn = (Button)findViewById(R.id.btnNextActivity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createInterstitialAd();
                // Interstitial ad failed to display. We recommend loading the next ad
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        maxAdView = findViewById(R.id.applovinbannerAd);
        maxAdView.loadAd();
        maxAdView.startAutoRefresh();

        max_mrec_adView = findViewById(R.id.max_mrec_adView);
        max_mrec_adView.loadAd();
        max_mrec_adView.startAutoRefresh();
    }
}