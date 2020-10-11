package com.barbuzinski.model;

import android.util.DisplayMetrics;

public class GridData {

    private static int widthCellsIso;
    private static float cellWidthToHeightRatio;
    private static DisplayMetrics metrics;

    private GridData() {}

    public static void init(int widthCellsIso, float cellWidthToHeightRatio, DisplayMetrics metrics) {
        GridData.widthCellsIso = widthCellsIso;
        GridData.cellWidthToHeightRatio = cellWidthToHeightRatio;
        GridData.metrics = metrics;
    }

    public static int getWidthCellsIso() {
        return widthCellsIso;
    }

    public static int getCellWidthPixels() {
        return metrics.widthPixels / widthCellsIso;
    }

    public static int getCellHeightPixels() {
        return (int) (getCellWidthPixels() * cellWidthToHeightRatio);
    }

}
