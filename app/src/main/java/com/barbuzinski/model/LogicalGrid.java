package com.barbuzinski.model;

public class LogicalGrid {

    public static final int EMPTY = 0;
    public static final int FIXED = 1;
    public static final int SINGLE = 2;
    public static final int DOUBLE = 3;

    private int widthCellsIso;
    private int heightCellsIso;

    private int[][] gridDefinition;

    public LogicalGrid(int widthCellsIso, int heightCellsIso, int[][] gridDefinition) {
        this.widthCellsIso = widthCellsIso;
        this.heightCellsIso = heightCellsIso;
        this.gridDefinition = gridDefinition;
    }

    public int getWidthCellsIso() {
        return widthCellsIso;
    }

    public int getHeightCellsIso() {
        return heightCellsIso;
    }

    public int getLogicalWidthCells() {
        return gridDefinition.length;
    }

    public int getLogicalHeightCells() {
        return gridDefinition[0].length;
    }

    public PavementGrid.Cell getCell(PavementGrid grid, int column, int row) {
        int i = gridDefinition[row][column];
        return i != EMPTY ? grid.new Cell(column, row) : null;
    }
}
