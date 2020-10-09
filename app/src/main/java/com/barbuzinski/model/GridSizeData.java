package com.barbuzinski.model;

public class GridSizeData {

    private int widthCellsIso;
    private int heightCellsIso;
    private int cellWidthPixels;

    public GridSizeData(int widthCellsIso, int heightCellsIso, int cellWidthPixels) {
        this.widthCellsIso = widthCellsIso;
        this.heightCellsIso = heightCellsIso;
        this.cellWidthPixels = cellWidthPixels;
    }

    public int getWidthCellsIso() {
        return widthCellsIso;
    }

    public int getHeightCellsIso() {
        return heightCellsIso;
    }

    public int getCellWidthPixels() {
        return cellWidthPixels;
    }

    public int getCellHeightPixels() {
        return getCellWidthPixels() / 2;
    }
}
