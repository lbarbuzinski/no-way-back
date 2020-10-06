package com.barbuzinski.android;

import android.graphics.Color;
import android.graphics.Paint;

public class PaintFactory {

    public Paint create(int red, int green, int blue) {
        Paint p = new Paint();
        p.setColor(Color.rgb(red, green, blue));
        return p;
    }

    public Paint createForVehicle() {
        return create(255, 0, 0);
    }
}
