package com.barbuzinski.model;

import android.view.MotionEvent;

public enum TouchSide {

    UP_LEFT,
    UP_RIGHT,
    DOWN_RIGHT,
    DOWN_LEFT;

    public static TouchSide determine(Vehicle vehicle, MotionEvent event) {
        if (event.getX() < vehicle.getCurrentPosition().getX()) {
            if (event.getY() < vehicle.getCurrentPosition().getY())
                return UP_LEFT;

            return DOWN_LEFT;
        }

        if (event.getY() < vehicle.getCurrentPosition().getY())
            return UP_RIGHT;

        return DOWN_RIGHT;
    }
}
