package com.barbuzinski.model.vehicle;

import com.barbuzinski.model.vehicle.state.VehicleState;

public interface VehicleStateCallback {

    VehicleStateCallback EMPTY_CALLBACK = (VehicleState newState) -> {};

    void onStateChanged(VehicleState newState);
}
