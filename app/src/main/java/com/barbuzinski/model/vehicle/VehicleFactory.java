package com.barbuzinski.model.vehicle;

import com.barbuzinski.model.Grid;
import com.barbuzinski.model.vehicle.state.VehicleStateFactory;

import javax.inject.Inject;

public class VehicleFactory {

    private final VehicleStateFactory vehicleStateFactory;

    @Inject
    public VehicleFactory(VehicleStateFactory vehicleStateFactory) {
        this.vehicleStateFactory = vehicleStateFactory;
    }

    public Vehicle create(Grid grid) {
        return new Vehicle(vehicleStateFactory.idle(grid.getInitialCell()));
    }
}
