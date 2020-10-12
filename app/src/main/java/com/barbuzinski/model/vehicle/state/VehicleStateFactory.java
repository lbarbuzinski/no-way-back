package com.barbuzinski.model.vehicle.state;

import com.barbuzinski.model.vehicle.cell.Cell;
import com.barbuzinski.model.vehicle.Vehicle;

public class VehicleStateFactory {

    public static VehicleState idle(Cell cell) {
        return new Idle(cell);
    }

    public static VehicleState movedFromIdle(Cell currentCell, Cell destCell, Vehicle vehicle) {
        return destCell.isEmpty() ?
                new Destroying(currentCell, destCell, vehicle) :
                new Riding(currentCell, destCell, vehicle);
    }

    public static VehicleState destroyed() {
        return new Destroyed();
    }
}
