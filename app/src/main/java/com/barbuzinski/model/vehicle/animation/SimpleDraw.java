package com.barbuzinski.model.vehicle.animation;

import android.graphics.Canvas;

import com.barbuzinski.android.PaintFactory;
import com.barbuzinski.model.GridData;
import com.barbuzinski.utils.StaticPosition;

import java.util.Optional;

import static com.barbuzinski.android.PaintFactory.FOR_VEHICLE;

public class SimpleDraw extends VehicleAnimation {

    protected StaticPosition position;

    public SimpleDraw(StaticPosition position) {
        this.position = position;
    }

    @Override
    public void draw(Canvas canvas) {
        FOR_VEHICLE.setAlpha(255);
        canvas.drawCircle(position.getX(), (float) (position.getY() - GridData.getCellHeightPixels() / 3),
                GridData.getCellWidthPixels() / 3 - 2,
                PaintFactory.FOR_VEHICLE);
    }

    @Override
    public Optional<StaticPosition> getPosition() {
        return Optional.of(position);
    }
}
