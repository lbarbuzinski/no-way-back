package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.cell.Cell;
import com.barbuzinski.model.vehicle.Vehicle;
import com.barbuzinski.model.vehicle.animation.SimpleDraw;

public class Idle extends VehicleState {

    private Cell currentCell;

    public Idle(Cell currentCell) {
        super(new SimpleDraw(currentCell.getPosition()));
        this.currentCell = currentCell;
    }

    @Override
    public VehicleStateEnum getState() {
        return VehicleStateEnum.IDLE;
    }

    @Override
    public VehicleState upLeft(Vehicle vehicle) {
        return onMoved(currentCell.getLeft(), vehicle);
    }

    @Override
    public VehicleState upRight(Vehicle vehicle) {
        return onMoved(currentCell.getTop(), vehicle);
    }

    @Override
    public VehicleState downLeft(Vehicle vehicle) {
        return onMoved(currentCell.getBottom(), vehicle);
    }

    @Override
    public VehicleState downRight(Vehicle vehicle) {
        return onMoved(currentCell.getRight(), vehicle);
    }

    private VehicleState onMoved(Cell destCell, Vehicle vehicle) {
        currentCell.onRanOver();
        return VehicleStateFactory.movedFromIdle(currentCell, destCell, vehicle);
    }

}
