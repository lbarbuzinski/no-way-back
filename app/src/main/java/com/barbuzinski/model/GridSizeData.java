package com.barbuzinski.model;

import android.util.DisplayMetrics;

public class GridSizeData {

    public static final int WIDTH_CELLS_ISO = 2;
    public static final int HEIGHT_CELLS_ISO = 3;

    private static GridSizeData instance;

    private int cellWidthPixels;

    private GridSizeData(DisplayMetrics metrics) {
        this.cellWidthPixels = metrics.widthPixels / WIDTH_CELLS_ISO;
    }

    public static void init(DisplayMetrics metrics) {
        instance = new GridSizeData(metrics);
    }

    public static int getWidthCellsIso() {
        return WIDTH_CELLS_ISO;
    }

    public static int getHeightCellsIso() {
        return HEIGHT_CELLS_ISO;
    }

    public static int getCellWidthPixels() {
        return instance.cellWidthPixels;
    }

    public static int getCellHeightPixels() {
        return getCellWidthPixels() / 2;
    }
}
