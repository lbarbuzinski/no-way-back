package com.barbuzinski.model;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public class LogicalGridFactory {

    public Grid createDefault(DisplayMetrics metrics, Drawable drawableCell) {
        int[][] gridDefinition = {
                {Grid.EMPTY, Grid.FIXED, Grid.EMPTY, Grid.EMPTY},
                {Grid.EMPTY, Grid.FIXED, Grid.EMPTY, Grid.EMPTY},
                {Grid.EMPTY, Grid.SINGLE, Grid.FIXED, Grid.EMPTY},
                {Grid.EMPTY, Grid.EMPTY, Grid.FIXED, Grid.EMPTY}
        };
        int widthCellsIso = 2;
        GridData.init(widthCellsIso, 0.5f, metrics);

        Cell[][] cellsMatrix = new Cell[gridDefinition.length][gridDefinition[0].length];
        for (int i = 0; i < cellsMatrix.length; i++) {
            for (int j = 0; j < cellsMatrix[0].length; j++) {
                Cell cell = new Cell(j, i, gridDefinition[i][j]);
                cellsMatrix[i][j] = cell;

                if (i > 0)
                    cell.setTop(cellsMatrix[i-1][j]);

                if (j > 0)
                    cell.setLeft(cellsMatrix[i][j-1]);
            }
        }

        return new Grid(cellsMatrix, drawableCell);
    }
}
