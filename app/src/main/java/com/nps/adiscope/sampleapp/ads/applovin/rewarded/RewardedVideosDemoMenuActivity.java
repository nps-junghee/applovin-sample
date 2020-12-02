package com.nps.adiscope.sampleapp.ads.applovin.rewarded;

import android.content.Intent;

import com.nps.adiscope.sampleapp.ads.applovin.DemoMenuActivity;
import com.nps.adiscope.sampleapp.data.main.DemoMenuItem;

public class RewardedVideosDemoMenuActivity
        extends DemoMenuActivity
{
    @Override
    protected DemoMenuItem[] getListViewContents()
    {
        return new DemoMenuItem[] {
                new DemoMenuItem( "Basic Integration", new Intent( this, RewardedVideosActivity.class ) ),
                new DemoMenuItem( "Zone Integration", new Intent( this, RewardedVideosZoneActivity.class ) )
        };
    }
}

