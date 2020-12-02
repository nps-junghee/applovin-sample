package com.nps.adiscope.sampleapp.ads.applovin.leaders;

import android.content.Intent;

import com.nps.adiscope.sampleapp.ads.applovin.DemoMenuActivity;
import com.nps.adiscope.sampleapp.data.main.DemoMenuItem;

public class LeaderDemoMenuActivity
        extends DemoMenuActivity
{
    @Override
    protected DemoMenuItem[] getListViewContents()
    {
        return new DemoMenuItem[] {
                new DemoMenuItem( "Programmatic", new Intent( this, LeaderProgrammaticActivity.class ) ),
                new DemoMenuItem( "Layout Editor", new Intent( this, LeaderLayoutEditorActivity.class ) ),
        };
    }
}
