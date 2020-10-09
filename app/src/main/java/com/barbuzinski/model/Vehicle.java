package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.barbuzinski.android.PaintFactory;

import static com.barbuzinski.model.AnimatedPosition.initial;
import static com.barbuzinski.model.PavementGrid.CELL_PADDING;

public class Vehicle {

    private PavementGrid grid;
    private Cell initialCell;
    private Cell currentCell;
    private Cell destCell;
    private AnimatedPosition currentAnimation;
    private int radius;
    private Paint vPaint;
    private boolean destroyed;

    public Vehicle(PavementGrid grid, Cell initialCell, PaintFactory paintFactory) {
        this.grid = grid;
        this.initialCell = initialCell;
        this.currentCell = initialCell;
        this.destCell = initialCell;
        this.currentAnimation = initial(currentCell.getPosition());
        this.radius = grid.getCellWidthPixels() / 3 - CELL_PADDING;

        this.vPaint = paintFactory.createForVehicle();
    }

    public ScreenPosition getCurrentPosition() {
        return currentAnimation.currentPosition();
    }

    public void upLeft() {
        setDestCell(currentCell.getLeft());
    }

    public void upRight() {
        setDestCell(currentCell.getTop());
    }

    public void downLeft() {
        setDestCell(currentCell.getBottom());
    }

    public void downRight() {
        setDestCell(currentCell.getRight());
    }

    private void setDestCell(Cell destCell) {
        if (currentAnimation.isDone())
            this.destCell = destCell;
    }

    public void draw(Canvas canvas) {
        if (currentAnimation.isDone()) {
            if (destroyed) {
                this.currentCell = initialCell;
                this.destCell = initialCell;
                this.currentAnimation = initial(currentCell.getPosition());
                destroyed = false;
            } else if (!currentCell.equals(destCell)) {
                currentAnimation = AnimatedPosition.start(currentCell.getPosition(), destCell.getPosition());
                this.currentCell = destCell;
                if (currentCell.isEmpty())
                    destroyed = true;
            }
        }

        ScreenPosition next = currentAnimation.currentPosition();
        canvas.drawCircle(next.getX(), next.getY() - grid.getCellHeightPixels() / 3, radius, vPaint);
    }


}
