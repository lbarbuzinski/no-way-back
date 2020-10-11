package com.barbuzinski.model;

public class LogicalGrid {

    public static final int FIXED = -1;
    public static final int EMPTY = 0;
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;

    private int widthCellsIso;
    private int heightCellsIso;

    private Cell[][] cellsMatrix;

    public LogicalGrid(Cell[][] cellsMatrix) {
        this.cellsMatrix = cellsMatrix;
    }

    public int getWidthCellsIso() {
        return GridSizeData.getWidthCellsIso();
    }

    public int getCellWidthPixels() {
        return GridSizeData.getCellWidthPixels();
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
}
