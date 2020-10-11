package com.barbuzinski.model.vehicle.animation;

import android.graphics.Canvas;

import com.barbuzinski.utils.StaticPosition;

import java.util.Optional;

public class NoDraw extends VehicleAnimation {

    public NoDraw() {
        super();
    }

    @Override
    public Optional<StaticPosition> getPosition() {
        return Optional.empty();
    }

    @Override
    public void draw(Canvas canvas) {}
}
