package com.barbuzinski.android;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class MetricsFactory {

    public DisplayMetrics create(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(metrics);

        return metrics;
    }
}
