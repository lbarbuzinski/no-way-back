package com.barbuzinski.model;

import com.barbuzinski.utils.position.StaticPosition;

import static com.barbuzinski.model.LogicalGrid.EMPTY;

public class Cell {

    private int x;
    private int y;
    private StaticPosition centerPosition;
    private int type;

    private Cell left;
    private Cell right;
    private Cell top;
    private Cell bottom;

    public Cell(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.centerPosition = new StaticPosition(computeX(), computeY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int computeX() {
        return (getX() - getY() + GridSizeData.getWidthCellsIso()) * GridSizeData.getCellWidthPixels() / 2;
    }

    private int computeY() {
        return (getX() + getY() - GridSizeData.getWidthCellsIso() + 2) * GridSizeData.getCellHeightPixels() / 2;
    }

    public Cell getLeft() {
        if (left == null)
            setLeft(new Cell(x - 1, y, EMPTY));

        return left;
    }

    public Cell getRight() {
        if (right == null)
            new Cell(x + 1, y, EMPTY).setLeft(this);

        return right;
    }

    public Cell getTop() {
        if (top == null)
            setTop(new Cell(x, y - 1, EMPTY));

        return top;
    }

    public Cell getBottom() {
        if (bottom == null)
            new Cell(x, y + 1, EMPTY).setTop(this);

        return bottom;
    }

    public StaticPosition getPosition() {
        return centerPosition;
    }

    public int getType() {
        return type;
    }

    public void onRanOver() {
        type--;
    }

    public boolean isEmpty() {
        return getType() == EMPTY;
    }

    public void setLeft(Cell left) {
        this.left = left;
        left.right = this;
    }

    public void setTop(Cell top) {
        this.top = top;
        top.bottom = this;
    }

}
