package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import com.barbuzinski.model.vehicle.Vehicle;
import com.barbuzinski.model.vehicle.VehicleFactory;

public class Level {

    protected Vehicle vehicle;
    protected Grid grid;

    private LogicalGridFactory logicalGridFactory;
    private VehicleFactory vehicleFactory;

    public Level(LogicalGridFactory logicalGridFactory, VehicleFactory vehicleFactory) {
        this.logicalGridFactory = logicalGridFactory;
        this.vehicleFactory = vehicleFactory;

        reinit();
    }

    private void reinit() {
        grid = logicalGridFactory.createDefault();
        vehicle = vehicleFactory.create(grid);
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
