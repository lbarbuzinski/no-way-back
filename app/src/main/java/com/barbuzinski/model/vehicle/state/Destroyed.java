package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.animation.VehicleAnimationFactory;

public class Destroyed extends VehicleState {

    public Destroyed(VehicleStateFactory vehicleStateFactory, VehicleAnimationFactory vehicleAnimationFactory) {
        super(vehicleStateFactory, vehicleAnimationFactory, vehicleAnimationFactory.noDraw());
    }

    @Override
    public VehicleStateEnum getState() {
        return VehicleStateEnum.DESTROYED;
    }

}
