package com.barbuzinski.model;

import com.barbuzinski.android.AnimationSettings;

public class AnimatedPosition {

    private boolean done;
    private long startedAt = System.currentTimeMillis();

    private ScreenPosition startPosition;
    private ScreenPosition destPosition;

    private AnimatedPosition(ScreenPosition startPosition, ScreenPosition destPosition, boolean done) {
        this.startPosition = startPosition;
        this.destPosition = destPosition;
        this.done = done;
    }

    public static AnimatedPosition start(ScreenPosition startPosition, ScreenPosition destPosition) {
        return new AnimatedPosition(startPosition, destPosition, false);
    }

    public static AnimatedPosition initial(ScreenPosition initialPosition) {
        return new AnimatedPosition(initialPosition, initialPosition, true);
    }

    public ScreenPosition currentPosition() {
        if (done)
            return destPosition;

        double distanceCovered = (System.currentTimeMillis() - startedAt) / (double) AnimationSettings.ONE_CELL_TRAVEL_TIME_MILLIS;
        if (distanceCovered >= 1d) {
            done = true;
            return destPosition;
        } else
            return new ScreenPosition(
                    (int) (startPosition.getX() + distanceCovered * (destPosition.getX() - startPosition.getX())),
                    (int) (startPosition.getY() + distanceCovered * (destPosition.getY() - startPosition.getY())));
    }

    public boolean isDone() {
        return done;
    }
}
