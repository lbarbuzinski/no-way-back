package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import com.barbuzinski.android.PaintFactory;

public class RectangularFixedGrid extends PavementGrid {

    private int widthCellsIso = 5;
    private int heightCellsIso = 5;

    private Drawable drawableGrid;

    public RectangularFixedGrid(DisplayMetrics metrics, Drawable drawableGrid, PaintFactory paintFactory) {
        super(metrics);
        this.drawableGrid = drawableGrid;

        vehicle = new Vehicle(
                this,
                new Cell(4, 3),
                paintFactory);
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        drawableGrid.draw(canvas);

        vehicle.draw(canvas);
    }

    @Override
    public boolean needsToBeRedrawn() {
        return true;
    }

    public int getCellWidthPixels() {
        return metrics.widthPixels / widthCellsIso;
    }

    public int getCellHeightPixels() {
        return metrics.widthPixels / 2 / heightCellsIso;
    }

    @Override
    public int getWidthCellsIso() {
        return widthCellsIso;
    }

    @Override
    public int getHeightCellsIso() {
        return heightCellsIso;
    }

}
