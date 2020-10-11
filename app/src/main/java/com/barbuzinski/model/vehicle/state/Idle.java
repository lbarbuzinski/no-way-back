package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.Cell;
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
        return VehicleStateFactory.movedFromIdle(currentCell, currentCell.getLeft(), vehicle);
    }

    @Override
    public VehicleState upRight(Vehicle vehicle) {
        return VehicleStateFactory.movedFromIdle(currentCell, currentCell.getTop(), vehicle);
    }

    @Override
    public VehicleState downLeft(Vehicle vehicle) {
        return VehicleStateFactory.movedFromIdle(currentCell, currentCell.getBottom(), vehicle);
    }

    @Override
    public VehicleState downRight(Vehicle vehicle) {
        return VehicleStateFactory.movedFromIdle(currentCell, currentCell.getRight(), vehicle);
    }

}
