package com.nps.adiscope.sampleapp.ads.max.banner;

import android.content.Intent;

import com.nps.adiscope.sampleapp.ads.applovin.DemoMenuActivity;
import com.nps.adiscope.sampleapp.data.main.DemoMenuItem;

public class BannerAdActivity
        extends DemoMenuActivity
{
    @Override
    protected DemoMenuItem[] getListViewContents()
    {
        DemoMenuItem[] result = {
                new DemoMenuItem( "Programmatic Banners", new Intent( this, ProgrammaticBannerAdActivity.class ) ),
                new DemoMenuItem( "Layout Editor Banners", new Intent( this, LayoutEditorBannerAdActivity.class ) ),
        };
        return result;
    }
}
