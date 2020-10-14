package com.barbuzinski;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;

@Module
@InstallIn(ActivityComponent.class)
public class NoWayBackModule {

    private static final Integer MAX_CELL_WIDTH_PIXELS = 200;

    @Provides
    public static DisplayMetrics displayMetrics(@ActivityContext Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(metrics);

        return metrics;
    }

    @Provides
    public static Integer widthCellsIso(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels / MAX_CELL_WIDTH_PIXELS;
    }

}
