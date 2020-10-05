package com.barbuzinski.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import androidx.core.content.res.ResourcesCompat;

import com.barbuzinski.R;

import java.util.Objects;

public class CustomGrid {

    private int widthCellsIso = 5;
    private int heightCellsIso = 5;

    private int cellWidth;
    private int cellHeight;

    private Resources res;
    private Drawable drawableGrid;
    private Vehicle vehicle;

    private DisplayMetrics metrics = new DisplayMetrics();

    private Point destPosition = new Point(0, 0);
    private Point prevPosition = new Point(0, 0);
    private Point currentPosition = new Point(0, 0);

    public int getCellWidthPixels() {
        return metrics.widthPixels / widthCellsIso;
    }

    public int getCellHeightPixels() {
        return metrics.widthPixels / 2 / heightCellsIso;
    }

    public int getWidthCellsIso() {
        return widthCellsIso;
    }

    public int getLogicalHeight() {
        return heightCellsIso;
    }

    public void draw(Canvas canvas) {
        if (!currentPosition.equals(destPosition)) {
            int xDiff = destPosition.x;
            int yDiff = destPosition.y;
        } else {
            prevPosition.set(destPosition.x, destPosition.y);
        }
        drawableGrid.draw(canvas);
        vehicle.draw(canvas);
    }

}
