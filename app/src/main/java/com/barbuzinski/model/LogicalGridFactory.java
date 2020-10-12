package com.barbuzinski.model;

import android.util.DisplayMetrics;

import com.barbuzinski.android.DrawablesRepository;
import com.barbuzinski.model.vehicle.cell.Cell;
import com.barbuzinski.model.vehicle.cell.CellStage;

public class LogicalGridFactory {

    private DrawablesRepository drawablesRepository;

    public LogicalGridFactory(DrawablesRepository drawablesRepository) {
        this.drawablesRepository = drawablesRepository;
    }

    public Grid createDefault(DisplayMetrics metrics) {
        CellStage[][] gridDefinition = {
                {CellStage.EMPTY, CellStage.FIXED, CellStage.EMPTY, CellStage.EMPTY},
                {CellStage.EMPTY, CellStage.DOUBLE, CellStage.EMPTY, CellStage.EMPTY},
                {CellStage.EMPTY, CellStage.DOUBLE, CellStage.DOUBLE, CellStage.EMPTY},
                {CellStage.EMPTY, CellStage.EMPTY, CellStage.SINGLE, CellStage.EMPTY}
        };
        int widthCellsIso = 2;
        GridData.init(widthCellsIso, 0.5f, metrics);

        Cell[][] cellsMatrix = new Cell[gridDefinition.length][gridDefinition[0].length];
        for (int i = 0; i < cellsMatrix.length; i++) {
            for (int j = 0; j < cellsMatrix[0].length; j++) {
                Cell cell = new Cell(j, i, gridDefinition[i][j], drawablesRepository);
                cellsMatrix[i][j] = cell;

                if (i > 0)
                    cell.setTop(cellsMatrix[i-1][j]);

                if (j > 0)
                    cell.setLeft(cellsMatrix[i][j-1]);
            }
        }

        return new Grid(cellsMatrix);
    }
}
