package com.barbuzinski.model.vehicle.animation;

import com.barbuzinski.utils.ProgressCompletedCallback;
import com.barbuzinski.utils.Animation;
import com.barbuzinski.utils.StaticPosition;

import java.util.Optional;

public abstract class VehicleAnimation extends Animation {

    protected VehicleAnimation() {}

    protected VehicleAnimation(int progressTimeMillis, ProgressCompletedCallback callback) {
        super(progressTimeMillis, callback);
    }

    public abstract Optional<StaticPosition> getPosition();

    public float progress() {
        return progress.progress();
    }
}
