package com.barbuzinski.model;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.barbuzinski.utils.StaticPosition;

public class Grid {

    public static final int FIXED = -1;
    public static final int EMPTY = 0;
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;

    private Cell[][] cellsMatrix;
    private Drawable drawableCell;

    public Grid(Cell[][] cellsMatrix, Drawable drawableCell) {
        this.cellsMatrix = cellsMatrix;
        this.drawableCell = drawableCell;
    }

    public int getLogicalWidthCells() {
        return cellsMatrix.length;
    }

    public int getLogicalHeightCells() {
        return cellsMatrix[0].length;
    }

    public Cell getCell(int column, int row) {
        return cellsMatrix[row][column];
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < getLogicalWidthCells(); i++) {
            for (int j = 0; j < getLogicalHeightCells(); j++) {
                Cell cell = getCell(i, j);
                if (!cell.isEmpty()) {
                    StaticPosition centerPosition = cell.getPosition();
                    int x = centerPosition.getX() - GridData.getCellWidthPixels() / 2;
                    int y = centerPosition.getY() - GridData.getCellHeightPixels() / 2;
                    drawableCell.setBounds(
                            x,
                            y,
                            x + GridData.getCellWidthPixels(),
                            y + GridData.getCellWidthPixels());
                    drawableCell.draw(canvas);
                }
            }
        }
    }
}
