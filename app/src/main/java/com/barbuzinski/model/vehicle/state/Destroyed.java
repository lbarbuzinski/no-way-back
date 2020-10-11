package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.animation.NoDraw;

public class Destroyed extends VehicleState {

    public Destroyed() {
        super(new NoDraw());
    }

    @Override
    public VehicleStateEnum getState() {
        return VehicleStateEnum.DESTROYED;
    }

}
