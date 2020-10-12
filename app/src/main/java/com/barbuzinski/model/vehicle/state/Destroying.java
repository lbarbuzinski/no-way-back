package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.cell.Cell;
import com.barbuzinski.model.vehicle.VehicleStateCallback;
import com.barbuzinski.model.vehicle.animation.Destruction;

import static com.barbuzinski.model.vehicle.state.VehicleStateFactory.destroyed;

public class Destroying extends VehicleState {

    public Destroying(Cell currentCell, Cell destCell, VehicleStateCallback callback) {
        super(new Destruction(currentCell.getPosition(), destCell.getPosition(), () -> callback.onStateChanged(destroyed())));
    }

    @Override
    public VehicleStateEnum getState() {
        return VehicleStateEnum.DESTROYING;
    }

}
