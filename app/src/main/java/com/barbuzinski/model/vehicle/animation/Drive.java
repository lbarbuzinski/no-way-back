package com.barbuzinski.model.vehicle.animation;

import android.graphics.Canvas;

import com.barbuzinski.model.GridSizeData;
import com.barbuzinski.utils.ProgressCompletedCallback;
import com.barbuzinski.utils.StaticPosition;

import static com.barbuzinski.android.PaintFactory.FOR_VEHICLE;

public class Drive extends TranslationAnimation {

    private static final int DRIVE_TIME_MILLIS = 200;

    public Drive(StaticPosition start, StaticPosition end, ProgressCompletedCallback callback) {
        super(DRIVE_TIME_MILLIS, callback, start, end);
    }

    @Override
    public void draw(Canvas canvas) {
        FOR_VEHICLE.setAlpha(255);

        StaticPosition position = position(progress.progress());
        canvas.drawCircle(position.getX(), (float) (position.getY() - GridSizeData.getCellHeightPixels() / 3),
                GridSizeData.getCellWidthPixels() / 3 - 2,
                FOR_VEHICLE);
    }
}
