package com.barbuzinski.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.barbuzinski.android.MetricsFactory;

import java.util.Objects;

public abstract class PavementGrid {

    static final int CELL_PADDING = 2;

    protected ScreenPosition currentPosition = new ScreenPosition(0, 0);

    protected Vehicle vehicle;

    protected DisplayMetrics metrics;

    protected PavementGrid(Context context, MetricsFactory metricsFactory) {
        this.metrics = metricsFactory.create(context);
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

    public abstract int getLogicalHeight();
    public abstract int getLogicalWidth();

    public abstract int getCellWidth();

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

    class Cell {

        private int x;
        private int y;
        private ScreenPosition centerPosition;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.centerPosition = new ScreenPosition(computeX(), computeY());
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Cell upLeft() {
            return x > 0 ? new Cell(this.x-1, this.y) : this;
        }

        public Cell upRight() {
            return y > 0 ? new Cell(this.x, this.y-1) : this;
        }

        public Cell downLeft() {
            return y < PavementGrid.this.getLogicalHeight() ? new Cell(this.x, this.y+1) : this;
        }

        public Cell downRight() {
            return x < PavementGrid.this.getLogicalWidth() ? new Cell(this.x+1, this.y) : this;
        }

        private int computeX() {
            return (getX() - getY() + PavementGrid.this.getWidthCellsIso()) * PavementGrid.this.getCellWidthPixels() / 2;
        }

        private int computeY() {
            return (getX() + getY() - PavementGrid.this.getWidthCellsIso() + 2) * PavementGrid.this.getCellHeightPixels() / 2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell that = (Cell) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public ScreenPosition getPosition() {
            return centerPosition;
        }
    }
}
