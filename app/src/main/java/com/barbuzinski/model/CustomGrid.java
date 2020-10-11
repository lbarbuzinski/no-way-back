package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import com.barbuzinski.model.vehicle.Vehicle;
import com.barbuzinski.utils.position.StaticPosition;

public class CustomGrid extends PavementGrid {

    private LogicalGrid logicalGrid;
    private Drawable drawableCell;

    public CustomGrid(DisplayMetrics metrics, LogicalGridFactory logicalGridFactory, Drawable drawableCell) {
        super(metrics);
        this.logicalGrid = logicalGridFactory.createDefault(metrics);
        this.drawableCell = drawableCell;

        initVehicle();
    }

    private void initVehicle() {
        vehicle = new Vehicle(logicalGrid.getCell(1, 0));
    }

    @Override
    public int getCellWidthPixels() {
        return logicalGrid.getCellWidthPixels();
    }

    @Override
    public int getCellHeightPixels() {
        return getCellWidthPixels() / 2;
    }

    @Override
    public int getWidthCellsIso() {
        return logicalGrid.getWidthCellsIso();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        for (int i = 0; i < logicalGrid.getLogicalWidthCells(); i++) {
            for (int j = 0; j < logicalGrid.getLogicalHeightCells(); j++) {
                Cell cell = logicalGrid.getCell(i, j);
                if (!cell.isEmpty()) {
                    StaticPosition centerPosition = cell.getPosition();
                    int x = centerPosition.getX() - getCellWidthPixels() / 2;
                    int y = centerPosition.getY() - getCellHeightPixels() / 2;
                    drawableCell.setBounds(
                            x,
                            y,
                            x + getCellWidthPixels(),
                            y + getCellWidthPixels());
                    drawableCell.draw(canvas);
                }
            }
        }

        if (vehicle.isDestroyed())
            initVehicle();

        vehicle.draw(canvas);
    }

    @Override
    public boolean needsToBeRedrawn() {
        return true;
    }
}
