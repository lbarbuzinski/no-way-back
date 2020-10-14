package com.barbuzinski.model.vehicle.animation;

import android.graphics.Canvas;

import com.barbuzinski.model.GridData;
import com.barbuzinski.utils.ProgressCompletedCallback;
import com.barbuzinski.utils.StaticPosition;

import static com.barbuzinski.android.PaintFactory.FOR_VEHICLE;

public class Destruction extends TranslationAnimation {

    private static final int DESTRUCTION_TIME_MILLIS = 200;

    private final GridData gridData;

    public Destruction(GridData gridData, StaticPosition start, StaticPosition end, ProgressCompletedCallback callback) {
        super(DESTRUCTION_TIME_MILLIS, callback, start, end);
        this.gridData = gridData;
    }

    @Override
    public void draw(Canvas canvas) {
        float progress = this.progress.progress();
        FOR_VEHICLE.setAlpha((int) (255 * (1.0f - progress)));

        StaticPosition position = position(progress);
        canvas.drawCircle(position.getX(), (float) (position.getY() - gridData.getCellHeightPixels() / 3),
                gridData.getCellWidthPixels() / 3 - 2,
                FOR_VEHICLE);
    }
}
