package com.barbuzinski.model;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import java.util.Objects;

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
    public abstract int getHeightCellsIso();

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
            return new Cell(this.x-1, this.y);
        }

        public Cell upRight() {
            return new Cell(this.x, this.y-1);
        }

        public Cell downLeft() {
            return new Cell(this.x, this.y+1);
        }

        public Cell downRight() {
            return new Cell(this.x+1, this.y);
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
