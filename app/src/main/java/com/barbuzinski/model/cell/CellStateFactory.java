package com.barbuzinski.model.cell;

import com.barbuzinski.android.DrawablesRepository;
import com.barbuzinski.model.GridData;

import javax.inject.Inject;

public class CellStateFactory {

    private final GridData gridData;
    private final DrawablesRepository drawablesRepository;
    private final CellAnimationFactory cellAnimationFactory;

    @Inject
    public CellStateFactory(GridData gridData, DrawablesRepository drawablesRepository, CellAnimationFactory cellAnimationFactory) {
        this.gridData = gridData;
        this.drawablesRepository = drawablesRepository;
        this.cellAnimationFactory = cellAnimationFactory;
    }

    public CellState create(int x, int y, CellStage stage) {
        return new CellState(gridData, cellAnimationFactory, drawablesRepository, x, y, stage);
    }
}
