package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import com.barbuzinski.android.PaintFactory;

public class CustomGrid extends PavementGrid {

    private LogicalGrid logicalGrid;

    private Drawable drawableCell;

    public CustomGrid(DisplayMetrics metrics, LogicalGrid logicalGrid, Drawable drawableCell, PaintFactory paintFactory) {
        super(metrics);
        this.logicalGrid = logicalGrid;
        this.drawableCell = drawableCell;

        vehicle = new Vehicle(
                this,
                new Cell(1, 0),
                paintFactory);
    }

    @Override
    public int getCellWidthPixels() {
        return metrics.widthPixels / getWidthCellsIso();
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
    public int getHeightCellsIso() {
        return logicalGrid.getHeightCellsIso();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        for (int i = 0; i < logicalGrid.getLogicalWidthCells(); i++) {
            for (int j = 0; j < logicalGrid.getLogicalHeightCells(); j++) {
                Cell cell = logicalGrid.getCell(this, i, j);
                if (cell != null) {
                    ScreenPosition centerPosition = cell.getPosition();
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

        vehicle.draw(canvas);
    }

    @Override
    public boolean needsToBeRedrawn() {
        return true;
    }
}
