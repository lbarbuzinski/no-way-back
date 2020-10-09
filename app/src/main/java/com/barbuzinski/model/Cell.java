package com.barbuzinski.model;

import static com.barbuzinski.model.LogicalGrid.EMPTY;

public class Cell {

    private final GridSizeData gridSizeData;

    private int x;
    private int y;
    private ScreenPosition centerPosition;
    private int type;

    private Cell left;
    private Cell right;
    private Cell top;
    private Cell bottom;

    public Cell(GridSizeData gridSizeData, int x, int y, int type) {
        this.gridSizeData = gridSizeData;
        this.x = x;
        this.y = y;
        this.type = type;
        this.centerPosition = new ScreenPosition(computeX(), computeY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int computeX() {
        return (getX() - getY() + gridSizeData.getWidthCellsIso()) * gridSizeData.getCellWidthPixels() / 2;
    }

    private int computeY() {
        return (getX() + getY() - gridSizeData.getWidthCellsIso() + 2) * gridSizeData.getCellHeightPixels() / 2;
    }

    public Cell getLeft() {
        if (left == null)
            setLeft(new Cell(gridSizeData, x - 1, y, EMPTY));

        return left;
    }

    public Cell getRight() {
        if (right == null)
            new Cell(gridSizeData, x + 1, y, EMPTY).setLeft(this);

        return right;
    }

    public Cell getTop() {
        if (top == null)
            setTop(new Cell(gridSizeData, x, y - 1, EMPTY));

        return top;
    }

    public Cell getBottom() {
        if (bottom == null)
            new Cell(gridSizeData, x, y + 1, EMPTY).setTop(this);

        return bottom;
    }

    public ScreenPosition getPosition() {
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
