package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.Vehicle;
import com.barbuzinski.model.vehicle.animation.VehicleAnimationFactory;
import com.barbuzinski.model.cell.Cell;

import javax.inject.Inject;

public class VehicleStateFactory {

    private final VehicleAnimationFactory vehicleAnimationFactory;

    @Inject
    public VehicleStateFactory(VehicleAnimationFactory vehicleAnimationFactory) {
        this.vehicleAnimationFactory = vehicleAnimationFactory;
    }

    public VehicleState idle(Cell cell) {
        return new Idle(this, vehicleAnimationFactory, cell);
    }

    public VehicleState movedFromIdle(Cell currentCell, Cell destCell, Vehicle vehicle) {
        return destCell.isEmpty() ?
                new Destroying(this, vehicleAnimationFactory, currentCell, destCell, vehicle) :
                new Riding(this, vehicleAnimationFactory, currentCell, destCell, vehicle);
    }

    public VehicleState destroyed() {
        return new Destroyed(this, vehicleAnimationFactory);
    }

}
