package com.barbuzinski.model.vehicle.animation;

import com.barbuzinski.utils.ProgressCompletedCallback;
import com.barbuzinski.utils.position.StaticPosition;

import java.util.Optional;

public abstract class TranslationAnimation extends VehicleAnimation {

    protected StaticPosition start;
    protected StaticPosition end;

    protected TranslationAnimation(int progressTimeMillis, ProgressCompletedCallback callback, StaticPosition start, StaticPosition end) {
        super(progressTimeMillis, callback);
        this.start = start;
        this.end = end;
    }

    protected StaticPosition position(float progress) {
        return new StaticPosition(
                (int) (start.getX() + progress * (end.getX() - start.getX())),
                (int) (start.getY() + progress * (end.getY() - start.getY())));
    }

    @Override
    public Optional<StaticPosition> getPosition() {
        return Optional.of(position(progress.progress()));
    }
}
