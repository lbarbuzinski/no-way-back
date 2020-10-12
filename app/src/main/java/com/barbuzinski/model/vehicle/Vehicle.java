package com.barbuzinski.model.vehicle;

import android.graphics.Canvas;

import com.barbuzinski.model.vehicle.cell.Cell;
import com.barbuzinski.model.vehicle.state.VehicleState;
import com.barbuzinski.model.vehicle.state.VehicleStateEnum;
import com.barbuzinski.model.vehicle.state.VehicleStateFactory;
import com.barbuzinski.utils.StaticPosition;

import java.util.Optional;

public class Vehicle implements VehicleStateCallback {

    private VehicleState state;

    public Vehicle(Cell initialCell) {
        this.state = VehicleStateFactory.idle(initialCell);
    }

    public Optional<StaticPosition> getCurrentPosition() {
        return state.getPosition();
    }

    public void upLeft() {
        setState(state.upLeft(this));
    }

    public void upRight() {
        setState(state.upRight(this));
    }

    public void downLeft() {
        setState(state.downLeft(this));
    }

    public void downRight() {
        setState(state.downRight(this));
    }

    private void setState(VehicleState newState) {
        this.state = newState;
    }

    public void draw(Canvas canvas) {
        state.draw(canvas);
    }

    @Override
    public void onStateChanged(VehicleState newState) {
        this.state = newState;
    }

    public boolean isDestroyed() {
        return getState() == VehicleStateEnum.DESTROYED;
    }

    VehicleStateEnum getState() {
        return state.getState();
    }
}
