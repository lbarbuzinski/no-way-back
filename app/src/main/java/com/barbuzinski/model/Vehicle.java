package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.barbuzinski.android.PaintFactory;

import static com.barbuzinski.model.AnimatedPosition.initial;
import static com.barbuzinski.model.PavementGrid.CELL_PADDING;

public class Vehicle {

    private PavementGrid grid;
    private PavementGrid.Cell currentCell;
    private PavementGrid.Cell destCell;
    private AnimatedPosition currentAnimation;
    private int radius;
    private Paint vPaint;

    public Vehicle(PavementGrid grid, RectangularFixedGrid.Cell currentCell, PaintFactory paintFactory) {
        this.grid = grid;
        this.currentCell = currentCell;
        this.currentAnimation = initial(currentCell.getPosition());
        this.radius = grid.getCellWidthPixels() / 3 - CELL_PADDING;

        this.vPaint = paintFactory.createForVehicle();
    }

    public ScreenPosition getCurrentPosition() {
        return currentAnimation.currentPosition();
    }

    public void upLeft() {
        setDestCell(currentCell.upLeft());
    }

    public void upRight() {
        setDestCell(currentCell.upRight());
    }

    public void downLeft() {
        setDestCell(currentCell.downLeft());
    }

    public void downRight() {
        setDestCell(currentCell.downRight());
    }

    private void setDestCell(PavementGrid.Cell destCell) {
        if (currentAnimation.isDone())
            this.destCell = destCell;
    }

    public void draw(Canvas canvas) {
        if (currentAnimation.isDone() && destCell != null && !currentCell.equals(destCell)) {
            currentAnimation = AnimatedPosition.start(currentCell.getPosition(), destCell.getPosition());
            this.currentCell = destCell;
        }

        ScreenPosition next = currentAnimation.currentPosition();
        canvas.drawCircle(next.getX(), next.getY() - grid.getCellHeightPixels() / 3, radius, vPaint);
    }


}
