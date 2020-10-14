package com.barbuzinski.model.cell;

import android.graphics.Canvas;

import com.barbuzinski.utils.StaticPosition;

import static com.barbuzinski.model.cell.CellStage.EMPTY;

public class Cell {

    private CellFactory cellFactory;

    private Cell left;
    private Cell right;
    private Cell top;
    private Cell bottom;

    private CellState cellState;

    public Cell(CellFactory cellFactory, CellStateFactory cellStateFactory, int x, int y, CellStage stage) {
        this.cellFactory = cellFactory;
        cellState = cellStateFactory.create(x, y, stage);
    }

    public Cell getLeft() {
        if (left == null)
            setLeft(cellFactory.createCell(cellState.getX() - 1, cellState.getY(), EMPTY));

        return left;
    }

    public Cell getRight() {
        if (right == null)
            cellFactory.createCell(cellState.getX() + 1, cellState.getY(), EMPTY).setLeft(this);

        return right;
    }

    public Cell getTop() {
        if (top == null)
            setTop(cellFactory.createCell(cellState.getX(), cellState.getY() - 1, EMPTY));

        return top;
    }

    public Cell getBottom() {
        if (bottom == null)
            cellFactory.createCell(cellState.getX(), cellState.getY() + 1, EMPTY).setTop(this);

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
