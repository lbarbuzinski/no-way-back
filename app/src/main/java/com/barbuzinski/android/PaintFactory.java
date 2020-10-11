package com.barbuzinski.android;

import android.graphics.Color;
import android.graphics.Paint;

public class PaintFactory {

    public static final Paint FOR_VEHICLE = new Paint();

    static {
        FOR_VEHICLE.setColor(Color.rgb(255, 0, 0));
    }

}
