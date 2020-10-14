package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.VehicleStateCallback;
import com.barbuzinski.model.vehicle.animation.VehicleAnimationFactory;
import com.barbuzinski.model.cell.Cell;

public class Destroying extends VehicleState {

    public Destroying(VehicleStateFactory vehicleStateFactory, VehicleAnimationFactory vehicleAnimationFactory, Cell currentCell, Cell destCell, VehicleStateCallback callback) {
        super(
                vehicleStateFactory,
                vehicleAnimationFactory,
                vehicleAnimationFactory.destruction(
                        currentCell.getPosition(),
                        destCell.getPosition(),
                        () -> callback.onStateChanged(vehicleStateFactory.destroyed())));
    }

    @Override
    public VehicleStateEnum getState() {
        return VehicleStateEnum.DESTROYING;
    }

}
