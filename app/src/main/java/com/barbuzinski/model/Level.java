package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.barbuzinski.model.vehicle.Vehicle;

public class Level {

    protected Vehicle vehicle;
    protected Grid grid;

    private DisplayMetrics metrics;
    private LogicalGridFactory logicalGridFactory;
    private Drawable drawableCell;

    public Level(DisplayMetrics metrics, LogicalGridFactory logicalGridFactory, Drawable drawableCell) {
        this.metrics = metrics;
        this.logicalGridFactory = logicalGridFactory;
        this.drawableCell = drawableCell;

        reinit();
    }

    private void reinit() {
        grid = logicalGridFactory.createDefault(metrics, drawableCell);
        vehicle = new Vehicle(grid.getCell(1, 0));
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        grid.draw(canvas);

        if (vehicle.isDestroyed())
            reinit();

        vehicle.draw(canvas);
    }

    public void onPavementTouched(MotionEvent event) {
        switch (TouchSide.determine(vehicle, event)) {
            case UP_LEFT: vehicle.upLeft(); break;
            case UP_RIGHT: vehicle.upRight(); break;
            case DOWN_LEFT: vehicle.downLeft(); break;
            case DOWN_RIGHT: vehicle.downRight(); break;
        }
    }

    public boolean needsToBeRedrawn() {
        return true;
    }
}
