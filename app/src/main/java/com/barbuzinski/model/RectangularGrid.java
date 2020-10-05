package com.barbuzinski.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.barbuzinski.android.DrawableGridFactory;
import com.barbuzinski.android.MetricsFactory;
import com.barbuzinski.android.PaintFactory;

public class RectangularGrid extends PavementGrid {

    private int widthCellsIso = 5;
    private int heightCellsIso = 5;

    private int cellWidth;
    private int cellHeight;

    private Drawable drawableGrid;

    private ScreenPosition destPosition = new ScreenPosition(0, 0);
    private ScreenPosition prevPosition = new ScreenPosition(0, 0);

    public RectangularGrid(Context context, DrawableGridFactory drawableGridFactory, MetricsFactory metricsFactory, PaintFactory paintFactory) {
        super(context, metricsFactory);
        drawableGrid = drawableGridFactory.create(context.getResources());

        cellHeight = metrics.widthPixels / 2 / heightCellsIso;

        vehicle = new Vehicle(
                this,
                new Cell(4, 3),
                paintFactory);

        //TODO read height and width from image
        drawableGrid.setBounds(currentPosition.getX(), destPosition.getY(), metrics.widthPixels, metrics.widthPixels / 2);
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

    public int getWidthCellsIso() {
        return widthCellsIso;
    }

    public int getLogicalWidth() {
        return widthCellsIso + heightCellsIso - 1;
    }

    @Override
    public int getCellWidth() {
        return metrics.widthPixels / widthCellsIso;
    }

    public int getLogicalHeight() {
        return getLogicalWidth();
    }

}
