package com.nps.adiscope.sampleapp.data.main;

import android.os.Build;
import android.util.Log;

import com.nps.adiscope.sampleapp.BuildConfig;
import com.applovin.sdk.AppLovinSdk;

import java.lang.reflect.Field;

public class FooterType
        implements com.nps.adiscope.sampleapp.data.main.ListItem
{
    private static final String TAG = "Footer";

    /**
     * @return The device details: App Version, SDK Version, OS Version
     */
    public String getAppDetails()
    {
        String appVersion = BuildConfig.VERSION_NAME;
        String sdkVersion = AppLovinSdk.VERSION;
        String versionName = versionName();
        int apiLevel = Build.VERSION.SDK_INT;

        String footer = "\nApp Version: " + appVersion +
                "\nSDK Version: " + sdkVersion +
                "\nOS Version: " + versionName + "(API " + apiLevel + ")";
        return footer;
    }

    private String versionName()
    {
        Field[] fields = Build.VERSION_CODES.class.getFields();
        for ( Field field : fields )
        {
            try
            {
                if ( field.getInt( Build.VERSION_CODES.class ) == Build.VERSION.SDK_INT )
                {
                    return field.getName();
                }
            }
            catch ( Throwable th )
            {
                Log.e( TAG, "Unable to get Android SDK codename", th );
            }
        }
        return "UNKNOWN";
    }

    @Override
    public int getType()
    {
        return TYPE_FOOTER;
    }
}
