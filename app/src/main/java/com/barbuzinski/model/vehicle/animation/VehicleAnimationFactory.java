package com.barbuzinski.model.vehicle.animation;

import com.barbuzinski.model.GridData;
import com.barbuzinski.utils.ProgressCompletedCallback;
import com.barbuzinski.utils.StaticPosition;

import javax.inject.Inject;

public class VehicleAnimationFactory {

    private final GridData gridData;

    @Inject
    public VehicleAnimationFactory(GridData gridData) {
        this.gridData = gridData;
    }

    public VehicleAnimation simpleDraw(StaticPosition position) {
        return new SimpleDraw(gridData, position);
    }

    public VehicleAnimation drive(StaticPosition currentPosition, StaticPosition destPosition, ProgressCompletedCallback callback) {
        return new Drive(gridData, currentPosition, destPosition, callback);
    }

    public VehicleAnimation destruction(StaticPosition currentPosition, StaticPosition destPosition, ProgressCompletedCallback callback) {
        return new Destruction(gridData, currentPosition, destPosition, callback);
    }

    public VehicleAnimation noDraw() {
        return new NoDraw();
    }
}
