package com.barbuzinski.model.vehicle.cell;

import android.graphics.Canvas;

import com.barbuzinski.android.DrawablesRepository;
import com.barbuzinski.utils.StaticPosition;

import static com.barbuzinski.model.vehicle.cell.CellStage.EMPTY;

public class Cell {

    private DrawablesRepository drawablesRepository;

    private Cell left;
    private Cell right;
    private Cell top;
    private Cell bottom;

    private CellState cellState;

    public Cell(int x, int y, CellStage stage, DrawablesRepository drawablesRepository) {
        cellState = new CellState(x, y, stage, drawablesRepository);
        this.drawablesRepository = drawablesRepository;
    }

    public Cell getLeft() {
        if (left == null)
            setLeft(new Cell(cellState.getX() - 1, cellState.getY(), EMPTY, drawablesRepository));

        return left;
    }

    public Cell getRight() {
        if (right == null)
            new Cell(cellState.getX() + 1, cellState.getY(), EMPTY, drawablesRepository).setLeft(this);

        return right;
    }

    public Cell getTop() {
        if (top == null)
            setTop(new Cell(cellState.getX(), cellState.getY() - 1, EMPTY, drawablesRepository));

        return top;
    }

    public Cell getBottom() {
        if (bottom == null)
            new Cell(cellState.getX(), cellState.getY() + 1, EMPTY, drawablesRepository).setTop(this);

        return bottom;
    }

    public StaticPosition getPosition() {
        return cellState.getPosition();
    }

    public CellStage getStage() {
        return cellState.getStage();
    }

    public void onRanOver() {
        cellState.onRanOver();
    }

    public boolean isEmpty() {
        return getStage() == EMPTY;
    }

    public void setLeft(Cell left) {
        this.left = left;
        left.right = this;
    }

    public void setTop(Cell top) {
        this.top = top;
        top.bottom = this;
    }

    public void draw(Canvas canvas) {
        cellState.draw(canvas);
    }

}
