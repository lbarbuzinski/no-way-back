package com.barbuzinski.model.vehicle.state;

import android.graphics.Canvas;

import com.barbuzinski.model.vehicle.Vehicle;
import com.barbuzinski.model.vehicle.animation.VehicleAnimation;
import com.barbuzinski.utils.StaticPosition;

import java.util.Optional;

public abstract class VehicleState {

    protected VehicleAnimation animation;

    protected VehicleState(VehicleAnimation animation) {
        this.animation = animation;
    }

    public abstract VehicleStateEnum getState();

    public void draw(Canvas canvas) {
        animation.draw(canvas);
    }

    public VehicleState upLeft(Vehicle vehicle) {
        return this;
    }

    public VehicleState upRight(Vehicle vehicle) {
        return this;
    }

    public VehicleState downLeft(Vehicle vehicle) {
        return this;
    }

    public VehicleState downRight(Vehicle vehicle) {
        return this;
    }

    public Optional<StaticPosition> getPosition() {
        return animation.getPosition();
    }
}
