package com.barbuzinski.model;

import android.util.DisplayMetrics;

import javax.inject.Inject;

public class GridData {

    private static final Float CELL_WIDTH_TO_HEIGHT_RATIO = 0.5f;

    private DisplayMetrics metrics;
    private Integer cellWidthPixels;
    private Integer widthCellsIso;

    @Inject
    public GridData(DisplayMetrics metrics, Integer widthCellsIso) {
        this.metrics = metrics;
        this.cellWidthPixels = metrics.widthPixels / widthCellsIso;
        this.widthCellsIso = widthCellsIso;
    }

    public int getWidthCellsIso() {
        return widthCellsIso;
    }

    public int getCellWidthPixels() {
        return cellWidthPixels;
    }

    public int getCellHeightPixels() {
        return (int) (getCellWidthPixels() * CELL_WIDTH_TO_HEIGHT_RATIO);
    }

}
