package com.barbuzinski.model;

import android.graphics.Canvas;

import com.barbuzinski.model.cell.Cell;

public class Grid {

    private Cell[][] cellsMatrix;

    public Grid(Cell[][] cellsMatrix) {
        this.cellsMatrix = cellsMatrix;
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
                getCell(i, j).draw(canvas);
            }
        }
    }

    public Cell getInitialCell() {
        return getCell(1, 0);
    }
}
