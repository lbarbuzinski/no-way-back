package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.cell.Cell;
import com.barbuzinski.model.vehicle.VehicleStateCallback;
import com.barbuzinski.model.vehicle.animation.VehicleAnimationFactory;

public class Riding extends VehicleState {

    public Riding(VehicleStateFactory vehicleStateFactory, VehicleAnimationFactory vehicleAnimationFactory, Cell currentCell, Cell destCell, VehicleStateCallback callback) {
        super(
                vehicleStateFactory,
                vehicleAnimationFactory,
                vehicleAnimationFactory.drive(
                        currentCell.getPosition(),
                        destCell.getPosition(),
                        () -> callback.onStateChanged(vehicleStateFactory.idle(destCell))));
    }

    @Override
    public VehicleStateEnum getState() {
        return VehicleStateEnum.RIDING;
    }

}
