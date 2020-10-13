package com.barbuzinski.model.vehicle.cell;

import com.barbuzinski.android.DrawablesRepository;

import javax.inject.Inject;

public class CellFactory {

    private final DrawablesRepository drawablesRepository;

    @Inject
    public CellFactory(DrawablesRepository drawablesRepository) {
        this.drawablesRepository = drawablesRepository;
    }

    public Cell createCell(int x, int y, CellStage stage) {
        return new Cell(x, y, stage, this, drawablesRepository);
    }
}
