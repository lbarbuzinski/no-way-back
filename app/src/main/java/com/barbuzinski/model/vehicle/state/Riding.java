package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.cell.Cell;
import com.barbuzinski.model.vehicle.VehicleStateCallback;
import com.barbuzinski.model.vehicle.animation.Drive;

import static com.barbuzinski.model.vehicle.state.VehicleStateFactory.idle;

public class Riding extends VehicleState {

    public Riding(Cell currentCell, Cell destCell, VehicleStateCallback callback) {
        super(new Drive(currentCell.getPosition(), destCell.getPosition(), () -> callback.onStateChanged(idle(destCell))));
    }

    @Override
    public VehicleStateEnum getState() {
        return VehicleStateEnum.RIDING;
    }

}
