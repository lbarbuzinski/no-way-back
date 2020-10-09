package com.barbuzinski.model;

import android.util.DisplayMetrics;

public class LogicalGridFactory {

    public LogicalGrid createDefault(DisplayMetrics metrics) {
        int widthCellsIso = 2;
        int heightCellsIso = 3;
        int[][] gridDefinition = {
                {LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.EMPTY, LogicalGrid.EMPTY},
                {LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.EMPTY, LogicalGrid.EMPTY},
                {LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.FIXED, LogicalGrid.EMPTY},
                {LogicalGrid.EMPTY, LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.EMPTY}
        };
        GridSizeData gridSizeData = new GridSizeData(widthCellsIso, heightCellsIso, metrics.widthPixels / widthCellsIso);

        Cell[][] cellsMatrix = new Cell[gridDefinition.length][gridDefinition[0].length];
        for (int i = 0; i < cellsMatrix.length; i++) {
            for (int j = 0; j < cellsMatrix[0].length; j++) {
                Cell cell = new Cell(gridSizeData, j, i, gridDefinition[i][j]);
                cellsMatrix[i][j] = cell;

                if (i > 0)
                    cell.setTop(cellsMatrix[i-1][j]);

                if (j > 0)
                    cell.setLeft(cellsMatrix[i][j-1]);
            }
        }
        return new LogicalGrid(
                gridSizeData,
                cellsMatrix);
    }
}
