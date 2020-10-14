package com.barbuzinski.model;

import com.barbuzinski.model.cell.Cell;
import com.barbuzinski.model.cell.CellFactory;
import com.barbuzinski.model.cell.CellStage;

import javax.inject.Inject;

public class LogicalGridFactory {

    private final CellFactory cellFactory;

    @Inject
    public LogicalGridFactory(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    public Grid createDefault() {
        CellStage[][] gridDefinition = {
                {CellStage.EMPTY, CellStage.FIXED, CellStage.EMPTY, CellStage.EMPTY},
                {CellStage.EMPTY, CellStage.DOUBLE, CellStage.EMPTY, CellStage.EMPTY},
                {CellStage.EMPTY, CellStage.DOUBLE, CellStage.DOUBLE, CellStage.EMPTY},
                {CellStage.EMPTY, CellStage.EMPTY, CellStage.SINGLE, CellStage.EMPTY}
        };

        Cell[][] cellsMatrix = new Cell[gridDefinition.length][gridDefinition[0].length];
        for (int i = 0; i < cellsMatrix.length; i++) {
            for (int j = 0; j < cellsMatrix[0].length; j++) {
                Cell cell = cellFactory.createCell(j, i, gridDefinition[i][j]);
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
