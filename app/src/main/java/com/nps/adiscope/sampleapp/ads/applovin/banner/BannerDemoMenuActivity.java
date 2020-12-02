package com.nps.adiscope.sampleapp.ads.applovin.banner;

import android.content.Intent;

import com.nps.adiscope.sampleapp.ads.applovin.DemoMenuActivity;
import com.nps.adiscope.sampleapp.data.main.DemoMenuItem;

public class BannerDemoMenuActivity
        extends DemoMenuActivity
{
    @Override
    protected DemoMenuItem[] getListViewContents()
    {
        return new DemoMenuItem[] {
                new DemoMenuItem( "Programmatic", new Intent( this, BannerProgrammaticActivity.class ) ),
                new DemoMenuItem( "Layout Editor", new Intent( this, BannerLayoutEditorActivity.class ) ),
                new DemoMenuItem( "Zone Integration", new Intent( this, BannerZoneActivity.class ) ),
        };
    }
}
