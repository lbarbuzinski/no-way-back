package com.barbuzinski.model;

import android.view.MotionEvent;

import com.barbuzinski.model.vehicle.Vehicle;
import com.barbuzinski.utils.position.StaticPosition;

public enum TouchSide {

    UP_LEFT,
    UP_RIGHT,
    DOWN_RIGHT,
    DOWN_LEFT,

    UNSPECIFIED;

    public static TouchSide determine(Vehicle vehicle, MotionEvent event) {
        if (!vehicle.getCurrentPosition().isPresent())
            return UNSPECIFIED;

        StaticPosition currentPosition = vehicle.getCurrentPosition().get();
        if (event.getX() < currentPosition.getX()) {
            if (event.getY() < currentPosition.getY())
                return UP_LEFT;

            return DOWN_LEFT;
        }

        if (event.getY() < currentPosition.getY())
            return UP_RIGHT;

        return DOWN_RIGHT;
    }
}
