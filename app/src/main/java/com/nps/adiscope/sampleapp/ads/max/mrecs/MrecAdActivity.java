package com.nps.adiscope.sampleapp.ads.max.mrecs;

import android.content.Intent;

import com.nps.adiscope.sampleapp.ads.applovin.DemoMenuActivity;
import com.nps.adiscope.sampleapp.data.main.DemoMenuItem;

public class MrecAdActivity
        extends DemoMenuActivity
{
    @Override
    protected DemoMenuItem[] getListViewContents()
    {
        DemoMenuItem[] result = {
                new DemoMenuItem( "Programmatic MRECs", new Intent( this, ProgrammaticMrecAdActivity.class ) ),
                new DemoMenuItem( "Layout Editor MRECs", new Intent( this, LayoutEditorMrecAdActivity.class ) ),
        };
        return result;
    }
}
