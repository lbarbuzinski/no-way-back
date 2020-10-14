package com.barbuzinski.model.cell;

import javax.inject.Inject;

public class CellFactory {

    private final CellStateFactory cellStateFactory;

    @Inject
    public CellFactory(CellStateFactory cellStateFactory) {
        this.cellStateFactory = cellStateFactory;
    }

    public Cell createCell(int x, int y, CellStage stage) {
        return new Cell(this, cellStateFactory, x, y, stage);
    }
}
