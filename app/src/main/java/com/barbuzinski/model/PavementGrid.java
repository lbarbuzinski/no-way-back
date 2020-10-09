package com.barbuzinski.model;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public abstract class PavementGrid {

    static final int CELL_PADDING = 2;

    protected Vehicle vehicle;

    protected DisplayMetrics metrics;

    protected PavementGrid(DisplayMetrics metrics) {
        this.metrics = metrics;
    }

    public void onPavementTouched(MotionEvent event) {
        switch (TouchSide.determine(vehicle, event)) {
            case UP_LEFT: upLeft(); break;
            case UP_RIGHT: upRight(); break;
            case DOWN_LEFT: downLeft(); break;
            case DOWN_RIGHT: downRight(); break;
        }
    }

    public abstract int getCellWidthPixels();
    public abstract int getCellHeightPixels();
    public abstract int getWidthCellsIso();

    public abstract void draw(Canvas canvas);

    public abstract boolean needsToBeRedrawn();

    public void upLeft() {
        vehicle.upLeft();
    }

    public void upRight() {
        vehicle.upRight();
    }

    public void downLeft() {
        vehicle.downLeft();
    }

    public void downRight() {
        vehicle.downRight();
    }

}
