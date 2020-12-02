package com.nps.adiscope.sampleapp.ads.max;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.nps.adiscope.sampleapp.R;
import com.nps.adiscope.sampleapp.ui.BaseAdActivity;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.ads.MaxInterstitialAd;

import java.util.concurrent.TimeUnit;

/**
 * An {@link android.app.Activity} used to show AppLovin MAX interstitial ads.
 * <p>
 * Created by santoshbagadi on 2019-09-10.
 */
public class InterstitialAdActivity
        extends BaseAdActivity
        implements MaxAdListener
{
    private MaxInterstitialAd interstitialAd;
    private int retryAttempt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_interstitial_ad );
        setTitle( R.string.activity_interstitial );

        setupCallbacksRecyclerView();

        interstitialAd = new MaxInterstitialAd( "YOUR_AD_UNIT_ID", this );
        interstitialAd.setListener( this );

        // Load the first ad.
        interstitialAd.loadAd();
    }

    public void onShowAdClicked(View view)
    {
        if ( interstitialAd.isReady() )
        {
            interstitialAd.showAd();
        }
    }

    //region MAX Ad Listener

    @Override
    public void onAdLoaded(final MaxAd ad)
    {
        // Interstitial ad is ready to be shown. interstitialAd.isReady() will now return 'true'.
        logCallback();

        // Reset retry attempt
        retryAttempt = 0;
    }

    @Override
    public void onAdLoadFailed(final String adUnitId, final int errorCode)
    {
        logCallback();

        // Interstitial ad failed to load. We recommend retrying with exponentially higher delays up to a maximum delay (in this case 64 seconds).

        retryAttempt++;
        long delayMillis = TimeUnit.SECONDS.toMillis( (long) Math.pow( 2, Math.min( 6, retryAttempt ) ) );

        new Handler().postDelayed( new Runnable()
        {
            @Override
            public void run()
            {
                interstitialAd.loadAd();
            }
        }, delayMillis );
    }

    @Override
    public void onAdDisplayFailed(final MaxAd ad, final int errorCode)
    {
        logCallback();

        // Interstitial ad failed to display. We recommend loading the next ad.
        interstitialAd.loadAd();
    }

    @Override
    public void onAdDisplayed(final MaxAd ad) { logCallback(); }

    @Override
    public void onAdClicked(final MaxAd ad) { logCallback(); }

    @Override
    public void onAdHidden(final MaxAd ad)
    {
        logCallback();

        // Interstitial Ad is hidden. Pre-load the next ad
        interstitialAd.loadAd();
    }

    //endregion
}
